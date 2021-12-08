package com.ccg.lab.Utils;

import java.time.LocalDateTime;

public class TimeCheck {
    public static boolean checkTime() {
        int hour = LocalDateTime.now().getHour();
        int minutes = LocalDateTime.now().getMinute();
        return (hour >= 9 && hour <= 11) || (hour == 12 && minutes == 0);
    }
}
