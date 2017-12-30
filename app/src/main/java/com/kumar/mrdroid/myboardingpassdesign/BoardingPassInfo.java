package com.kumar.mrdroid.myboardingpassdesign;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * Created by mrdroid on 30/12/17.
 */

public class BoardingPassInfo {

    public String passengerName;
    public String flightCode;
    public String originCode;
    public String destCode;

    public Timestamp boardingTime;
    public Timestamp departureTime;
    public Timestamp arrivalTime;

    public String departureTerminal;
    public String departureGate;
    public String seatNumber;

    public int barCodeImageResource;

    public long getMinutesUntilBoarding() {
        long millisUntilBoarding = boardingTime.getTime() - System.currentTimeMillis();
        return TimeUnit.MILLISECONDS.toMinutes(millisUntilBoarding);
    }
}
