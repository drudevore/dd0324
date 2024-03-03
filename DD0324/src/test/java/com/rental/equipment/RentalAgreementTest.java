/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rental.equipment;

import com.rental.equipment.data.Tool;
import com.rental.equipment.data.ToolCharges;
import com.rental.equipment.data.Tools;
import java.util.Calendar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ddevo
 */
public class RentalAgreementTest {
    
    public RentalAgreementTest() {
    }

    /**
     * Test of printReport method, of class RentalAgreement.
     */
    @Test
    public void testPrintReport() throws Exception {
        System.out.println("printReport");
        Tool tool = Tools.getTool("JAKD");
        int rentalDays = 5;
        int discount = 29;
        Calendar checkoutDate = Calendar.getInstance();
        checkoutDate.set(Calendar.MONTH, Calendar.JULY);
        checkoutDate.set(Calendar.DAY_OF_MONTH, 2);
        checkoutDate.set(Calendar.YEAR, 2026);
        RentalAgreement agreement = Cart.checkout(tool, rentalDays, discount, 
                checkoutDate);
        agreement.printReport();
        
        assertEquals(agreement.getToolCode(), tool.getCode());
        assertEquals(agreement.getToolType(), tool.getType());
        assertEquals(agreement.getToolBrand(), tool.getBrand());
        assertEquals(agreement.getRentalDays(), rentalDays);
        assertEquals(agreement.getCheckoutDate(), checkoutDate);
        checkoutDate.add(Calendar.DAY_OF_MONTH, rentalDays);
        assertEquals(agreement.getDueDate(), checkoutDate);
        assertEquals(agreement.getDailyRentalCharge(), 
                ToolCharges.getCharge(tool.getType()).getDailyCharge());
        assertEquals(agreement.getChargeDays(), 2);
        assertEquals(agreement.getPreDiscountCharge(), 5.98);
        assertEquals(agreement.getDiscount(), discount);
        assertEquals(agreement.getDiscountAmount(), 0.87);
        assertEquals(agreement.getFinalCharge(), 5.11);
        
        System.out.println("RentalAgreementTest.testPrintReport() test complete.");        
    }
}
