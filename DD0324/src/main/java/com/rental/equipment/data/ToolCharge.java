/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rental.equipment.data;

import com.rental.equipment.utils.Holiday;
import java.util.Calendar;

/**
 *
 * @author ddevo
 */
public class ToolCharge {

    private String toolType = null;
    private double dailyCharge = 0.0;
    private boolean weekdayCharge = false;
    private boolean weekendCharge = false;
    private boolean holidayCharge = false;

    /**
     * Creates a ToolCharge instance.
     * 
     * @param toolType
     * @param dailyCharge
     * @param weekdayCharge
     * @param weekendCharge
     * @param holidayCharge 
     */
    public ToolCharge(String toolType, double dailyCharge, 
            boolean weekdayCharge, boolean weekendCharge, 
            boolean holidayCharge){
        this.toolType = toolType;
        this.dailyCharge = dailyCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }
    
    /**
     * Returns the number of charge days for the tool associated with this 
     * ToolCharge object. 
     * 
     * @param checkout
     * @param rentDays
     * @return the number of days to charge for the tool based on the checkout
     *         date and the rental days. 
     */
    public int calculateChargeDays(Calendar checkout, int rentDays) {
        Calendar cal = (Calendar)checkout.clone();
        int chargeDays = 0;
        for (int i = 0; i < rentDays; i++) {
            // Increasing the present day by 1. We don't figure the renting day
            // as being a charged day.
            cal.add(Calendar.DAY_OF_MONTH, 1);
            if (!holidayCharge && Holiday.isHoliday(cal)) {
                // If the day is a holiday and we don't charge for holidays 
                // then continue to the next day.
                continue; 
            }

            int dow = cal.get(Calendar.DAY_OF_WEEK);
            if (dow == Calendar.SATURDAY || dow == Calendar.SUNDAY) {
                // It is the weekend. We need to see if we charge for weekends.
                if (weekendCharge) {
                    chargeDays++;
                }
            } else if (weekdayCharge) {
                // Charge if it is a weekday.
                chargeDays++;
            }
        }
        return chargeDays;
    }
    
    /**
     * @return the toolType
     */
    public String getToolType() {
        return toolType;
    }

    /**
     * @param toolType the toolType to set
     */
    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    /**
     * @return the dailyCharge
     */
    public double getDailyCharge() {
        return dailyCharge;
    }

    /**
     * @param dailyCharge the dailyCharge to set
     */
    public void setDailyCharge(double dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    /**
     * @return the weekdayCharge
     */
    public boolean isWeekdayCharge() {
        return weekdayCharge;
    }

    /**
     * @param weekdayCharge the weekdayCharge to set
     */
    public void setWeekdayCharge(boolean weekdayCharge) {
        this.weekdayCharge = weekdayCharge;
    }

    /**
     * @return the weekendCharge
     */
    public boolean isWeekendCharge() {
        return weekendCharge;
    }

    /**
     * @param weekendCharge the weekendCharge to set
     */
    public void setWeekendCharge(boolean weekendCharge) {
        this.weekendCharge = weekendCharge;
    }

    /**
     * @return the holidayCharge
     */
    public boolean isHolidayCharge() {
        return holidayCharge;
    }

    /**
     * @param holidayCharge the holidayCharge to set
     */
    public void setHolidayCharge(boolean holidayCharge) {
        this.holidayCharge = holidayCharge;
    }

    /**
     * Converts the ToolCharge instance into a string.
     * 
     * @return the String the ToolCharge instance was converted into.
     */
    @Override
    public String toString() {
        return String.format("%s, %.2f ,%b, %b, %b", this.toolType, 
                this.dailyCharge, this.weekdayCharge, this.weekendCharge, 
                this.holidayCharge);
    }
}
