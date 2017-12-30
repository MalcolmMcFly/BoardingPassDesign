package com.kumar.mrdroid.myboardingpassdesign;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kumar.mrdroid.myboardingpassdesign.databinding.ActivityMainBinding;
import com.kumar.mrdroid.myboardingpassdesign.utilities.FakeBoardingDataUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        BoardingPassInfo fakeBoardingInfo = FakeBoardingDataUtils.generateFakeBoardingPassInfo();
        displayBoardingPassInfo(fakeBoardingInfo);


    }

    private void displayBoardingPassInfo(BoardingPassInfo info){

         mainBinding.tvPassangerName.setText(info.passengerName);
         mainBinding.tvSource.setText(info.originCode);
         mainBinding.tvDestination.setText(info.destCode);
         mainBinding.tvFlightCode.setText(info.flightCode);

         // format time in specific format
         SimpleDateFormat formatter= new SimpleDateFormat(getString(R.string.timeFormat), Locale.getDefault());
         String boardingTime = formatter.format(info.boardingTime);
         String departureTime = formatter.format(info.departureTime);
         String arrivalTime = formatter.format(info.arrivalTime);
         
         mainBinding.tvBoardingTime.setText(boardingTime);
         mainBinding.tvDeparture.setText(departureTime);
         mainBinding.tvArrival.setText(arrivalTime);

         // calculation for getting countdown time
         long totalMinutesUntilBoarding = info.getMinutesUntilBoarding();
         long hoursUntilBoarding = TimeUnit.MINUTES.toHours(totalMinutesUntilBoarding);
         long minutesLessHoursTillBoarding =
                 totalMinutesUntilBoarding - TimeUnit.HOURS.toMinutes(hoursUntilBoarding);

         //format for countDownTime
         String hoursAndMinutesBoarding = getString(
                 R.string.countDownFormat,
                 hoursUntilBoarding,
                 minutesLessHoursTillBoarding);

         mainBinding.tvBoardingIN.setText(hoursAndMinutesBoarding);
         mainBinding.tvTerminalNo.setText(info.departureTerminal);
         mainBinding.tvGate.setText(info.departureGate);
         mainBinding.tvSeat.setText(info.seatNumber);

    }
}
