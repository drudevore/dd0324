/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rental.equipment;

import com.rental.equipment.data.Tool;
import java.util.Calendar;

/**
 *
 * @author ddevo
 */
public class Cart {
    
    private Tool tool = null;
    private int rentalDays = 0;
    private int discount = 0;
    private Calendar checkoutDate = null;
    
    private final static String RENTAL_EXCEPTION_MESSAGE = 
            "To be able to rent equipment the rental days must be more than "
            + "1 day. Please set the rental day count to more than 1 day.";
    private final static String DISCOUNT_EXCEPTION_MESSAGE = 
            "The discount percentage must be between 0 and 100. Please set "
            + "the percentage to a correct amount.";
    private final static String CHECKOUT_DATE_EXCEPTION_MESSAGE = 
            "The checkout date must be today or later.";

    /**
     * Initialization method for the Cart object used to hold the cart data for 
     * the application. 
     * 
     * @param tool
     * @param rentalDays
     * @param discount
     * @param checkoutDate
     * @throws Exception 
     */
    public Cart(Tool tool, int rentalDays, int discount, 
            Calendar checkoutDate) throws Exception {
        if (rentalDays < 1) { 
            throw new Exception(RENTAL_EXCEPTION_MESSAGE);
        }
        
        if (discount < 0 || discount > 100) {
            throw new Exception(DISCOUNT_EXCEPTION_MESSAGE);
        }
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        if (checkoutDate.before(cal)) {
            throw new Exception(CHECKOUT_DATE_EXCEPTION_MESSAGE);
        }
        
        this.tool = tool;
        this.rentalDays = rentalDays;
        this.discount = discount;
        this.checkoutDate = checkoutDate;
    }

    /**
     * @return the tool
     */
    public Tool getTool() {
        return tool;
    }

    /**
     * @param tool the tool to set
     */
    public void setTool(Tool tool) {
        this.tool = tool;
    }

    /**
     * @return the rentalDayCount
     */
    public int getRentalDays() {
        return rentalDays;
    }

    /**
     * @param rentalDays the rentalDayCount to set
     * @throws java.lang.Exception
     */
    public void setRentalDays(int rentalDays) throws Exception {
        if (rentalDays < 1) { 
            throw new Exception(RENTAL_EXCEPTION_MESSAGE);
        }
        this.rentalDays = rentalDays;
    }

    /**
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     * @throws java.lang.Exception
     */
    public void setDiscount(int discount) throws Exception {
        if (discount < 0 || discount > 100) {
            throw new Exception(DISCOUNT_EXCEPTION_MESSAGE);
        }
        
        this.discount = discount;
    }

    /**
     * @return the checkoutDate
     */
    public Calendar getCheckoutDate() {
        return checkoutDate;
    }

    /**
     * @param checkoutDate the checkoutDate to set
     * @throws java.lang.Exception
     */
    public void setCheckoutDate(Calendar checkoutDate) throws Exception {
        if (checkoutDate.before(Calendar.getInstance())) {
            throw new Exception(CHECKOUT_DATE_EXCEPTION_MESSAGE);
        }
        
        this.checkoutDate = checkoutDate;
    }
}
