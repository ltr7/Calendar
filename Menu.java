/*
 * File: Menu.java
 * Created: 2018/12/22
 * Last Modified: 2019/01/07
 * Author: Lee Rice <Lee.Rice7@gmail.com>
 */

package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Menu class to allow user to select various calendar functions.
 *
 * @author Lee Rice
 */
class Menu {

    /**
     * Creates a menu for display to the user and handles calendar function selection.
     */
    void menu() {
        Calendar newCal = new Calendar();
        HashMap<String, Event> calMap = new HashMap<>();
        int userChoice;

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        do {
            System.out.println("Please choose an option: ");
            System.out.println("1. Add calendar event ");
            System.out.println("2. Delete calendar event ");
            System.out.println("3. Display remaining agenda for the week ");
            System.out.println("4. Exit the calendar ");
            System.out.print("Please enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            userChoice = scanner.nextInt();

            if (userChoice == 1) {
                boolean validDate = false;
                boolean validStartTime = false;
                boolean validEndTime = false;
                Date formattedDate = new Date();
                String startTime = "";
                String endTime = "";

                while (!validDate) {
                    System.out.print("Please enter the date of new event (MM-DD-YYYY): ");
                    String date = scanner.next();
                    try {
                        formattedDate = dateFormat.parse(date);
                        validDate = true;
                    } catch (ParseException e) {
                        System.out.println("Incorrect date format.  Please try again.\n");
                    }
                }

                while (!validStartTime) {
                    System.out.print("Please enter the start time of the event (HH:MM): ");
                    startTime = scanner.next();
                    try {
                        LocalTime.parse(startTime);
                        validStartTime = true;
                    } catch (DateTimeParseException | NullPointerException e) {
                        System.out.println("Incorrect time format.  Please try again.\n");
                    }
                }

                while (!validEndTime) {
                    System.out.print("Please enter the end time of the event (HH:MM): ");
                    endTime = scanner.next();

                    try {
                        LocalTime.parse(endTime);
                        validEndTime = true;
                    } catch (DateTimeParseException | NullPointerException e) {
                        System.out.println("Incorrect time format.  Please try again. \n");
                    }
                }

                System.out.print("Please enter a description of the event: ");
                String description = scanner.next();

                Event newEvent = new Event(formattedDate, startTime, endTime, description);
                newCal.addEvent(calMap, newEvent);


                System.out.println("Event entered. ");


            } else if (userChoice == 2) {
                System.out.print("Please enter the date of event you would like removed (MM-DD-YYYY): ");
                String date = scanner.next();

                System.out.print("Please enter the start time of event you would like removed (HH:MM): ");
                String startTime = scanner.next();
                String key = date + startTime;

                if (calMap.containsKey(key)) {
                    newCal.removeEvent(calMap, calMap.get(key));
                    System.out.println("Event removed.");
                } else {
                    System.out.println("An event with that date and start time does not exist in the calendar.");
                }

            } else if (userChoice == 3) {
                newCal.printRemainingAgendaForTheWeek(calMap);

            }

        } while (userChoice != 4);
    }
}
