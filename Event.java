/*
 * File: Event.java
 * Created: 2018/12/22
 * Last Modified: 2019/01/07
 * Author: Lee Rice <Lee.Rice7@gmail.com>
 */

package com.company;

import java.util.Date;

/**
 * Creates an event  to be added to the calendar.
 *
 * @author Lee Rice
 */
class Event {
    Date date;
    String startTime;
    String endTime;
    String description;

    /**
     * Creates an event to be added to the calendar from used provided parameters.
     *
     * @param date Date of the event
     * @param startTime Starting time of the event
     * @param endTime Ending time of the event
     * @param description User provided description of the event
     */
    Event(Date date, String startTime, String endTime, String description) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

}