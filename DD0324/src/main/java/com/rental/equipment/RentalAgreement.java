/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rental.equipment;

import com.rental.equipment.data.ToolCharge;
import com.rental.equipment.data.ToolCharges;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author ddevo
 */
public class RentalAgreement {
    
    private Cart cart = null;

    /**
     * Initialization method for the RentalAgreement object to be used to 
     * create a RentalAgreement for reporting calculating most of the fields 
     * for the rental agreement as well as printing the rental agreement to the
     * console. 
     * 
     * @param cart
     */
    protected RentalAgreement(Cart cart) {
        this.cart = cart;
    }
    
    /**
     * @return the calculated from discount % and pre-discount charge. 
     *         Resulting amount rounded half up to cents.
     */
    public double calculateDiscountAmount() {
        return RentalAgreement.roundHalfUp(
                calculatePreDiscountCharge() * (cart.getDiscount()/100));
    }

    /**
     * @return the due date of the tool based on the checkout day and 
     *         rental days.
     */
    public Calendar calculateDueDate() {
        Calendar checkout = getCheckoutDate();
        checkout.add(Calendar.DAY_OF_MONTH, cart.getRentalDays());
        return checkout;
    }

    /**
     * @return the Calculated as pre-discount charge - discount amount.
     */
    public double calculateFinalCharge() {
        return RentalAgreement.roundHalfUp(calculatePreDiscountCharge() 
                - calculateDiscountAmount());
    }

    /**
     * @return the Calculated as charge days X daily charge. Resulting total 
     *         rounded half up to cents.
     */
    public double calculatePreDiscountCharge() {
        return getDailyRentalCharge() * getChargeDays();
    }

    /**
     * @return the Count of chargeable days, from day after checkout through 
     *         and including due date, excluding “no charge” days as specified 
     *         by the tool type.
     */
    public int getChargeDays() {
        ToolCharge charge = ToolCharges.getCharge(cart.getTool().getType());
        return charge.calculateChargeDays(getCheckoutDate(), getRentalDays());
    }

    /**
     * @return the checkoutDate
     */
    public Calendar getCheckoutDate() {
        return cart.getCheckoutDate();
    }

    /**
     * @return the dailyRentalCharge
     */
    public double getDailyRentalCharge() {
        return ToolCharges.getCharge(cart.getTool().getType()).getDailyCharge();
    }
    
    /** 
     * @return the discount amount as an integer.
     */
    public int getDiscount() {
        return cart.getDiscount();
    }
    
    /**
     * @return the rentalDays
     */
    public int getRentalDays() {
        return cart.getRentalDays();
    }

    /**
     * @return the toolBrand
     */
    public String getToolBrand() {
        return cart.getTool().getBrand();
    }

    /**
     * @return the toolCode
     */
    public String getToolCode() {
        return cart.getTool().getCode();
    }

    /**
     * @return the toolType
     */
    public String getToolType() {
        return cart.getTool().getType();
    }
    
    /**
     * Prints a report of the Agreement to the console.
     */
    public void printReport() {
        SimpleDateFormat calFormatter = new SimpleDateFormat("MM/dd/yy");
        NumberFormat currFormatter = NumberFormat.getCurrencyInstance();
        
        System.out.println("Tool Code:           " + cart.getTool().getCode());
        System.out.println("Tool Type:           " + cart.getTool().getType());
        System.out.println("Tool Brand:          " + cart.getTool().getBrand());
        System.out.println("Rental Days:         " + cart.getRentalDays());
        System.out.println("Checkout Date:       " + 
                calFormatter.format(getCheckoutDate().getTime()));
        System.out.println("Due Date:            " + 
                calFormatter.format(calculateDueDate().getTime()));
        System.out.println("Daily Rental Charge: " + 
                currFormatter.format(getDailyRentalCharge()));
        System.out.println("Charge Days:         " + getChargeDays());
        System.out.println("Pre-Discount Charge: " + 
                currFormatter.format(calculatePreDiscountCharge()));
        System.out.println("Discount Percent:    " + getDiscount() + "%");
        System.out.println("Discount Amount:     " + 
                currFormatter.format(calculateDiscountAmount()));
        System.out.println("Final Charge:        " + 
                currFormatter.format(calculateFinalCharge()));
    }
    
    /** 
     * Helper method to half round up the dollar amounts after calculations. 
     * 
     * @param amount
     * @return a double value that has been rounded half up.
     */
    private static double roundHalfUp(double amount) {
        BigDecimal bd = new BigDecimal(amount);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
