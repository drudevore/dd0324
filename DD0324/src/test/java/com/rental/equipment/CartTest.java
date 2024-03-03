/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rental.equipment;

import com.rental.equipment.data.Tool;
import com.rental.equipment.data.Tools;
import java.util.Calendar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ddevo
 */
public class CartTest {
    
    public CartTest() {
    }
    
    /**
     * Test of checkout method, of class Cart.
     */
    @Test
    public void testCheckout_0args() throws Exception {
        System.out.println("checkout 0");
        Cart cart = new Cart();
        cart.setCheckoutDate(Calendar.getInstance());
        cart.setDiscountPercent(29);
        cart.setRentalDays(5);
        cart.setTool(Tools.getTool("JAKD"));
        RentalAgreement result = cart.checkout();
        assertNotNull(result);

        System.out.println("CartTest.testCheckout_0args() test complete.");        
    }

    /**
     * Test of checkout method, of class Cart.
     */
    @Test
    public void testCheckout_4args_1() throws Exception {
        System.out.println("checkout 4-1");
        String toolCode = "JAKD";
        int rentalDays = 5;
        int discount = 29;
        Calendar checkoutDate = Calendar.getInstance();
        RentalAgreement result = Cart.checkout(toolCode, rentalDays, discount, checkoutDate);
        assertNotNull(result);

        System.out.println("CartTest.testCheckout_4args_1() test complete.");        
    }

    /**
     * Test of checkout method, of class Cart.
     */
    @Test
    public void testCheckout_4args_2() throws Exception {
        System.out.println("checkout 4-2");
        Tool tool = Tools.getTool("JAKD");
        int rentalDays = 5;
        int discount = 29;
        Calendar checkoutDate = Calendar.getInstance();
        RentalAgreement result = Cart.checkout(tool, rentalDays, discount, checkoutDate);
        assertNotNull(result);

        System.out.println("CartTest.testCheckout_4args_2() test complete.");        
    }

    /**
     * Test of setToolCode method, of class Cart.
     */
    @Test
    public void testSetToolCode() {
        System.out.println("setToolCode");
        String toolCode = "JAKD";
        Cart cart = new Cart();
        cart.setToolCode(toolCode);
        assertEquals(toolCode, cart.getTool().getCode());

        System.out.println("CartTest.testSetToolCode test complete.");        
    }
}
