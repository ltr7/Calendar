/*
 * File: Event.java
 * Created: 2018/12/22
 * Last Modified: 2019/01/07
 * Author: Lee Rice <Lee.Rice7@gmail.com>
 */

package com.company;

import java.util.Date;

class Event {
    Date date;
    String startTime;
    String endTime;
    String description;

    Event(Date date, String startTime, String endTime, String description){
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

}
