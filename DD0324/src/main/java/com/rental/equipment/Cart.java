/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rental.equipment;

import com.rental.equipment.data.Tool;
import com.rental.equipment.data.Tools;
import com.rental.equipment.exception.CheckoutException;
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
    
    private final static String TOOL_EXCEPTION_MESSAGE = 
            "There must be a tool entered into the cart to create a rental "
            + "agreement. Please add a tool to the cart and try to checkout "
            + "again.";
    private final static String RENTAL_EXCEPTION_MESSAGE = 
            "The rental days must be 1 or more to rent equipment. Please set "
            + "the rental day count to 1 or more days and try to checkout "
            + "again.";
    private final static String DISCOUNT_EXCEPTION_MESSAGE = 
            "The discount percentage must be between 0 and 100. Please set "
            + "the percentage to an amount between 0 and 100 and try to "
            + "checkout again.";
    private final static String CHECKOUT_DATE_EXCEPTION_MESSAGE = 
            "The checkout date must be today or later. Please set the checkout "
            + "date to today or later and try to checkout again.";

    /**
     * Initializes the cart without any of the required information to checkout
     */
    public Cart() {}
    
    /**
     * Initialization method for the Cart object used to hold the cart data for 
     * the application. 
     * 
     * @param toolCode the tool code for the tool to be rented.
     * @param rentalDays the number of days the tool will be rented.
     * @param discount the discount that will be applied to the rental.
     * @param checkoutDate the date the rental tool will be rented.
     */
    public Cart(String toolCode, int rentalDays, int discount, 
            Calendar checkoutDate) {
        this.tool = Tools.getTool(toolCode);
        this.rentalDays = rentalDays;
        this.discount = discount;
        this.checkoutDate = checkoutDate;
    }
    
    /**
     * Method for checking the renter out and crating the rental agreement. 
     * 
     * @return the RentalAgreement. 
     * @throws com.rental.equipment.exception.CheckoutException 
     */
    public RentalAgreement checkout() throws CheckoutException {
        // All values in the cart are required to create a rental agreement.
        if (tool == null) {
            throw new CheckoutException(TOOL_EXCEPTION_MESSAGE);
        }
        
        if (rentalDays < 1) { 
            throw new CheckoutException(RENTAL_EXCEPTION_MESSAGE);
        }
        
        if (discount < 0 || discount > 100) {
            throw new CheckoutException(DISCOUNT_EXCEPTION_MESSAGE);
        }
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        if (checkoutDate == null || checkoutDate.before(cal)) {
            throw new CheckoutException(CHECKOUT_DATE_EXCEPTION_MESSAGE);
        }
        
        return new RentalAgreement(this);
    }
    
    /**
     * Creates a RentalAgreement without a cart being created already. 
     * 
     * @param toolCode the tool code for the tool to be rented.
     * @param rentalDays the number of days the tool will be rented.
     * @param discount the discount that will be applied to the rental.
     * @param checkoutDate the date the rental tool will be rented.
     * @return the RentalAgreement.
     * @throws com.rental.equipment.exception.CheckoutException
     */
    public static RentalAgreement checkout(String toolCode, int rentalDays, 
            int discount, Calendar checkoutDate) throws CheckoutException {
        Cart cart = new Cart(toolCode, rentalDays, discount, checkoutDate);
        return cart.checkout();
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
     * @param toolCode the code of the tool to be rented.
     */
    public void setToolCode(String toolCode) {
        if (toolCode == null) {
            return;
        }
        tool = Tools.getTool(toolCode);
    }

    /**
     * @return the rentalDayCount
     */
    public int getRentalDays() {
        return rentalDays;
    }

    /**
     * @param rentalDays the rentalDayCount to set
     */
    public void setRentalDays(int rentalDays) {
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
     */
    public void setDiscount(int discount) {
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
     */
    public void setCheckoutDate(Calendar checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
