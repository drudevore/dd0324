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
    
    private int chargeDays = 0;
    private double dailyRentalCharge = 0.0;
    private double discountAmount = 0.0;
    private Calendar dueDate = null;
    private double finalCharge = 0.0;
    private double preDiscountCharge = 0.0;

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
        
        // The charge days is the numbers of days to charge the customer for the
        // rental based on the checkout day, weekday charges, weekend charges, 
        // and holiday charges. It is calculated by the ToolCharge object. 
        ToolCharge charge = ToolCharges.getCharge(cart.getTool().getType());
        this.chargeDays = charge.calculateChargeDays(cart.getCheckoutDate(), 
                cart.getRentalDays());
                
        // The daily rental charge comes from the ToolCharge object which is 
        // gotten by using the tool type from the tool in the cart.
        this.dailyRentalCharge = charge.getDailyCharge();
        
        // Pre-Discount is the daily rental charge * the charge days.
        this.preDiscountCharge = this.dailyRentalCharge * this.chargeDays;
        
        // The discount amount is calculated using the daily rental charge
        // * the discount as a precent. This value is rounded half up.
        this.discountAmount = RentalAgreement.roundHalfUp(this.dailyRentalCharge
                * (cart.getDiscountPercent()/100.0));   

        // The due date is calculated adding the rental days to the checkout
        // date.
        this.dueDate = (Calendar)cart.getCheckoutDate().clone();
        this.dueDate.add(Calendar.DAY_OF_MONTH, cart.getRentalDays());
        
        // Final charge is the amount pre-discount - the discount amount 
        // and it is roiunded half up.
        this.finalCharge = RentalAgreement.roundHalfUp(this.preDiscountCharge 
                - this.discountAmount);
    }
    
    /**
     * @return the charge days for the tool. 
     */
    public int getChargeDays() {
        return chargeDays;
    }

    /**
     * @return the checkout date set by the user.
     */
    public Calendar getCheckoutDate() {
        return cart.getCheckoutDate();
    }

    /**
     * @return the daily rental charge for the tool.
     */
    public double getDailyRentalCharge() {
        return dailyRentalCharge;
    }
    
    /** 
     * @return the discount amount as an integer.
     */
    public int getDiscount() {
        return cart.getDiscountPercent();
    }
    
    /**
     * @return the amount discounted for the user.
     */
    public double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * @return the due date of the tool based on the checkout day and 
     *         rental days.
     */
    public Calendar getDueDate() {
        return dueDate;
    }

    /**
     * @return the final charge for the rental.
     */
    public double getFinalCharge() {
        return finalCharge;
    }

    /**
     * @return the pre-discounted charge for the rental.
     */
    public double getPreDiscountCharge() {
        return preDiscountCharge;
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
        
        System.out.println("Tool Code:           " + getToolCode());
        System.out.println("Tool Type:           " + getToolType());
        System.out.println("Tool Brand:          " + getToolBrand());
        System.out.println("Rental Days:         " + getRentalDays());
        System.out.println("Checkout Date:       " + 
                calFormatter.format(getCheckoutDate().getTime()));
        System.out.println("Due Date:            " + 
                calFormatter.format(getDueDate().getTime()));
        System.out.println("Daily Rental Charge: " + 
                currFormatter.format(getDailyRentalCharge()));
        System.out.println("Charge Days:         " + getChargeDays());
        System.out.println("Pre-Discount Charge: " + 
                currFormatter.format(getPreDiscountCharge()));
        System.out.println("Discount Percent:    " + getDiscount() + "%");
        System.out.println("Discount Amount:     " + 
                currFormatter.format(getDiscountAmount()));
        System.out.println("Final Charge:        " + 
                currFormatter.format(getFinalCharge()));
    }
    
    /**
     * Converts the RentalAgreement to a string. 
     * 
     * @retrun a String representation of the RentalAgreement.
     */
    @Override
    public String toString() {
        return "Tool Code:" + getToolCode() 
                + ";Tool Type:" + getToolType() 
                + ";Tool Brand:" + getToolBrand() 
                + ";Rental Days:" + getRentalDays() 
                + ";Checkout Date:" + getCheckoutDate()
                + ";Due Date:" + getDueDate()
                + ";Daily Rental Charge:" + getDailyRentalCharge()
                + ";Charge Days:" + getChargeDays()
                + ";Pre-Discount Charge:" + getPreDiscountCharge()
                + ";Discount Percent:" + getDiscount()
                + ";Discount Amount:" + getDiscountAmount()
                + ";Final Charge:" + getFinalCharge();
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
