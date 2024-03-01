/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rental.equipment.data;

/**
 *
 * @author ddevo
 */
public class Tool {
    
    private String code = null;
    private String type = null;
    private String brand = null;
    
    /**
     * Creates an instance of a tool. 
     * 
     * @param code
     * @param type
     * @param brand 
     */
    protected Tool(String code, String type, String brand) {
        this.code = code;
        this.type = type;
        this.brand = brand;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Converts the tool to a simple string.
     * 
     * @return 
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s", this.code, this.getType(), 
                this.brand);
    }
}
