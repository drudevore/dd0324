/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rental.equipment.utils;

import java.util.Calendar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ddevo
 */
public class HolidayTest {
    
    public HolidayTest() {
    }
    
    /**
     * Test of isHoliday method, of class Holiday.
     */
    @Test
    public void testIsHoliday() {
        Calendar day = Calendar.getInstance();
        boolean result = false;

        // Day = 07/06/24
        System.out.println("Not a holiday.");
        day.set(Calendar.MONTH, Calendar.JULY);
        day.set(Calendar.DAY_OF_MONTH, 6);
        day.set(Calendar.YEAR, 2024);
        result = Holiday.isHoliday(day);
        assertFalse(result);
        
        // Day = 07/3/2026
        System.out.println("Friday July 3 2026");
        day.set(Calendar.MONTH, Calendar.JULY);
        day.set(Calendar.DAY_OF_MONTH, 3);
        day.set(Calendar.YEAR, 2026);
        result = Holiday.isHoliday(day);
        assertTrue(result);

        // Day = 07/4/2026
        System.out.println("Satruday July 4 2026");
        day.set(Calendar.MONTH, Calendar.JULY);
        day.set(Calendar.DAY_OF_MONTH, 4);
        day.set(Calendar.YEAR, 2026);
        result = Holiday.isHoliday(day);
        assertFalse(result);

        // Day = 07/4/2027
        System.out.println("Sunday July 4 2027");
        day.set(Calendar.MONTH, Calendar.JULY);
        day.set(Calendar.DAY_OF_MONTH, 4);
        day.set(Calendar.YEAR, 2027);
        result = Holiday.isHoliday(day);
        assertFalse(result);

        // Day = 07/5/2027
        System.out.println("Monday July 5 2027");
        day.set(Calendar.MONTH, Calendar.JULY);
        day.set(Calendar.DAY_OF_MONTH, 5);
        day.set(Calendar.YEAR, 2027);
        result = Holiday.isHoliday(day);
        assertTrue(result);

        // Day = 07/4/2024
        System.out.println("Thursday July 4 2024");
        day.set(Calendar.MONTH, Calendar.JULY);
        day.set(Calendar.DAY_OF_MONTH, 5);
        day.set(Calendar.YEAR, 2027);
        result = Holiday.isHoliday(day);
        assertTrue(result);

        // Day = 09/02/24
        System.out.println("Monday September 2 Labor Day");
        day.set(Calendar.MONTH, Calendar.SEPTEMBER);
        day.set(Calendar.DAY_OF_MONTH, 2);
        day.set(Calendar.YEAR, 2024);
        result = Holiday.isHoliday(day);
        assertTrue(result);

        // Day = 09/09/24
        System.out.println("Monday September 9 Labor Day");
        day.set(Calendar.MONTH, Calendar.SEPTEMBER);
        day.set(Calendar.DAY_OF_MONTH, 9);
        day.set(Calendar.YEAR, 2024);
        result = Holiday.isHoliday(day);
        assertFalse(result);
        
        System.out.println("HolidayTest.testIsHoliday tests complete.");
    }
}
