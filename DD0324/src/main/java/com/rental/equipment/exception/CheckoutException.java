/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rental.equipment.exception;

/**
 * This is an Exception to be thrown by the cart in the rental equipment project
 * if the values in the cart are not populated properly.
 * 
 * @author ddevo
 */
public class CheckoutException extends Exception {

    public CheckoutException(String message) {
        super(message);
    }    
}
