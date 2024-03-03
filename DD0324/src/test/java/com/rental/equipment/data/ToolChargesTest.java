/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rental.equipment.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ddevo
 */
public class ToolChargesTest {

    public ToolChargesTest() {
    }
    
    /**
     * Test of getCharges method, of class ToolCharges.
     */
    @Test
    public void testGetCharges() {
        ToolCharge[] charges = ToolCharges.getCharges();
        System.out.println("Charges length = " + charges.length);
        assertEquals(charges.length, 3);
        
        System.out.println("ToolChargesTest.testGetCharges() test complete.");
    }

    /**
     * Test of getCharge method, of class ToolCharges.
     */
    @Test
    public void testGetCharge() {
        String toolType = "";
        ToolCharge[] charges = ToolCharges.getCharges();
        for (ToolCharge charge : charges) {
            toolType = ToolCharges.getCharge(charge.getToolType()).getToolType();
            System.out.println("Tooltype = " + toolType);
            assertEquals(charge.getToolType(), toolType);
        }

        System.out.println("ToolChargesTest.testGetCharge() test complete.");
    }
}
