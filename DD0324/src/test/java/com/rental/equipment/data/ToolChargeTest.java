/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rental.equipment.data;

import java.util.Calendar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ddevo
 */
public class ToolChargeTest {
    
    public ToolChargeTest() {
    }
    
    /**
     * Test of calculateChargeDays method, of class ToolCharge.
     */
    @Test
    public void testCalculateChargeDays() {
        Calendar checkout = Calendar.getInstance();
        int rentDays = 5;
        int chargeDays = 0;
        ToolCharge toolCharge = ToolCharges.getCharge("Chainsaw");
        System.out.println("instance = " + toolCharge);
        
        System.out.println("Testing Chainsaw 3 days");
        System.out.println("Friday July 2 2026");
        checkout.set(Calendar.MONTH, Calendar.JULY);
        checkout.set(Calendar.DAY_OF_MONTH, 2);
        checkout.set(Calendar.YEAR, 2026);
        chargeDays = toolCharge.calculateChargeDays(checkout, rentDays);
        System.out.println("rentdays = " + rentDays + " chargeDays = " + chargeDays);
        assertEquals(3, chargeDays);
        
        System.out.println("Testing Ladder 4 days");
        System.out.println("Friday July 3 2026");
        toolCharge = ToolCharges.getCharge("Ladder");
        checkout.set(Calendar.MONTH, Calendar.JULY);
        checkout.set(Calendar.DAY_OF_MONTH, 2);
        checkout.set(Calendar.YEAR, 2026);
        chargeDays = toolCharge.calculateChargeDays(checkout, rentDays);
        System.out.println("rentdays = " + rentDays + " chargeDays = " + chargeDays);
        assertEquals(4, chargeDays);

        System.out.println("Testing Jackhammer 2 days");
        System.out.println("Friday July 3 2026");
        toolCharge = ToolCharges.getCharge("Jackhammer");
        checkout.set(Calendar.MONTH, Calendar.JULY);
        checkout.set(Calendar.DAY_OF_MONTH, 2);
        checkout.set(Calendar.YEAR, 2026);
        chargeDays = toolCharge.calculateChargeDays(checkout, rentDays);
        System.out.println("rentdays = " + rentDays + " chargeDays = " + chargeDays);
        assertEquals(2, chargeDays);
    }
}
