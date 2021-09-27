package com.rules.calendar1;

import org.kie.api.time.Calendar;
import org.quartz.impl.calendar.WeeklyCalendar;

public class WeekDayNotInclud3Calendar implements Calendar {
    @Override
    public boolean isTimeIncluded(long timestamp) {
        WeeklyCalendar weeklyCalendar = new WeeklyCalendar();
        weeklyCalendar.setDayExcluded(java.util.Calendar.WEDNESDAY, true);
        return weeklyCalendar.isTimeIncluded(timestamp);
    }
}
