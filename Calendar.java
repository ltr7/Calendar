/*
 * File: Calendar.java
 * Created: 2018/12/22
 * Last Modified: 2019/01/07
 * Author: Lee Rice <Lee.Rice7@gmail.com>
 */

package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Calendar class contains the implementations of the various functions of the calendar.
 *
 * @author Lee Rice
 */
class Calendar {
    /**
     * Adds an event to the map.
     * Big O Average Time Complexity Hash Map insertion: O(1)
     *
     * @param map   Map containing calendar events
     * @param event Event to be added to the calendar
     */
    void addEvent(HashMap map, Event event) {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String dateString = dateFormat.format(event.date);
        String key = dateString + event.startTime;
        map.put(key, event);

    }

    /**
     * Removes an event from the map
     * Big O Average Time Complexity Hash Map removal: O(1)
     *
     * @param map   Map containing calendar events
     * @param event Event to be added to the calendar
     */
    void removeEvent(HashMap map, Event event) {
        map.remove(event.date + event.startTime);
    }

    /**
     * Removes an event from the map
     * Big O Best Case Time Complexity Map search: O(n)  Worst case: O(n^7)
     * All key, value pairs stored in map must be searched for each day left in the week
     *
     * @param map Map containing calendar events
     */
    void printRemainingAgendaForTheWeek(HashMap map) {
        Date currentDate = new Date();
        DateFormat dayInYear = new SimpleDateFormat("D");
        DateFormat dayInWeek = new SimpleDateFormat("E");
        DateFormat shortDate = new SimpleDateFormat("MM-dd-yyyy");
        String dayInString = dayInWeek.format(currentDate);
        int intDayOfYear = Integer.parseInt(dayInYear.format(currentDate));
        int remainingDays = 0;

        switch (dayInString) {
            case "Mon":
                remainingDays = 6;
                break;

            case "Tue":
                remainingDays = 5;
                break;

            case "Wed":
                remainingDays = 4;
                break;

            case "Thu":
                remainingDays = 3;
                break;

            case "Fri":
                remainingDays = 2;
                break;

            case "Sat":
                remainingDays = 1;
                break;

            case "Sun":
                remainingDays = 0;
                break;

            default:
                System.out.println("Something went wrong in the remaining days switch statement ");
        }

        for (int i = 0; i < remainingDays + 1; i++) {
            for (Object key : map.keySet()) {

                Event currentEvent = (Event) map.get(key);
                int intDayChecked = Integer.parseInt(dayInYear.format(currentEvent.date));

                if (intDayChecked == (intDayOfYear)) {
                    System.out.println("\nEvent Date: " + shortDate.format(currentEvent.date));
                    System.out.println("Start Time: " + currentEvent.startTime);
                    System.out.println("End Time: " + currentEvent.endTime);
                    System.out.println("Description: " + currentEvent.description + "\n");
                }

            }

            intDayOfYear++;

            DateFormat convertedYear = new SimpleDateFormat("y");
            int currentYear = Integer.parseInt(convertedYear.format(currentDate));
            GregorianCalendar leapCheck = new GregorianCalendar();

            if (intDayOfYear > 365 && !leapCheck.isLeapYear(currentYear)) {
                intDayOfYear = 0;

            } else {
                if (intDayOfYear > 366) {
                    intDayOfYear = 0;
                }
            }
        }
    }
}