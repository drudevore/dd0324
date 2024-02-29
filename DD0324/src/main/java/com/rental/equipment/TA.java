/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.rental.equipment;

import com.rental.equipment.utils.Holiday;
import com.rental.equipment.data.ToolCharges;
import com.rental.equipment.data.Tools;
import com.rental.equipment.exception.CheckoutException;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author ddevo
 */
public class TA {
    
    public static void main(String[] args) {
        System.out.println("Technical Assessment");
        ToolCharges.initializeToolCharges();
        Tools.initializeTools();
        
//        testTools();
//        testToolCharges();
        testHoliday();
        testAgreement();
    }
    
    private static void testTools() {
        System.out.println("Tools: " + Arrays.toString(Tools.getTools()));
        System.out.println("JAKD exists = " + Tools.getTool("Jackhammer", "DeWalt"));
    }

    private static void testToolCharges() {
        System.out.println("ToolCharges: " + Arrays.toString(ToolCharges.getCharges()));
    }
    
    private static void testHoliday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.JULY);
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.DAY_OF_MONTH, 5);
        System.out.println("Holiday = " + Holiday.isHoliday(calendar));
    }
    
    private static void testAgreement() {
        Cart cart = null;
        RentalAgreement agreement = null;
        Calendar start = Calendar.getInstance();
        start.set(Calendar.MONTH, Calendar.JULY);
        start.set(Calendar.DAY_OF_MONTH, 2);
        start.set(Calendar.YEAR, 2026);
        try {
//            cart = new Cart(Tools.getTool("CHNS"), 5, 28, start);
//            agreement = cart.checkout();
            agreement = Cart.checkout("CHNS", 5, 29, start);
        } catch (CheckoutException e) {
            System.out.println("exception = " + e);
            return;
        }
//        System.out.println("tool charge = " + ToolCharges.getCharge(cart.getTool().getType()));
        System.out.println("charge days = " + agreement.getChargeDays());

        System.out.println("prediscount charge = " + agreement.calculatePreDiscountCharge());
        System.out.println("discount amount = " + agreement.calculateDiscountAmount());
        System.out.println("final Charge = " + agreement.calculateFinalCharge());
        agreement.printReport();
    }
    
    public static void printCalendar(Calendar cal) {
        System.out.println("cal = " + cal);
        System.out.println("day = " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("month = " + cal.get(Calendar.MONTH));
        System.out.println("year = " + cal.get(Calendar.YEAR));
    }
}
