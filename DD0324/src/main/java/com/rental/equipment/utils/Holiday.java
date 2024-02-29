/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rental.equipment.utils;

import java.util.Calendar;

/**
 * Utility class to calculate if the day is a holiday. 
 * 
 * @author ddevo
 */
public class Holiday {
    
    /**
     * Main method to calculate if the day provided is a holiday.
     * 
     * @param day
     * @return 
     */
    public static boolean isHoliday(Calendar day) {
        return isLaborDay(day) || isIndependenceDay(day);
    }
    
    /**
     * Method to calculate if the day is observed for independence day.
     * 
     * @param day
     * @return 
     */
    private static boolean isIndependenceDay(Calendar day) {
        if (day.get(Calendar.MONTH) == Calendar.JULY) {
            int date = day.get(Calendar.DATE);
            int dow = day.get(Calendar.DAY_OF_WEEK);
            if ((date != 4 || dow == Calendar.SUNDAY) ||
                    dow == Calendar.SATURDAY) {
                if (date == 3 && dow == Calendar.FRIDAY ||
                        date == 5 && dow == Calendar.MONDAY) {
                    
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to calculate if the day is Labor day. 
     * 
     * @param day
     * @return 
     */
    private static boolean isLaborDay(Calendar day) {
        return day.get(Calendar.MONTH) == Calendar.SEPTEMBER 
                && day.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY 
                && day.get(Calendar.DAY_OF_MONTH) < 8;
    }
    
}
