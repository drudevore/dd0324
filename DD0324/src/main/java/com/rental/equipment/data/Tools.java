/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rental.equipment.data;

/**
 *
 * @author ddevo
 */
public class Tools {
    
    private static Tool[] tools = null;

    /**
     * Initializes the tools object that contains an array with the tools in it.
     */
    public static void initializeTools() {
        tools = new Tool[4];
        tools[0] = new Tool("CHNS", "Chainsaw", "Stihl");
        tools[1] = new Tool("LADW", "Ladder", "Werner");
        tools[2] = new Tool("JAKD", "Jackhammer", "DeWalt");
        tools[3] = new Tool("JAKR", "Jackhammer", "Ridgid");
    }
    
    /**
     * 
     * @param code
     * @return the Tool object associated with the provided code.
     */
    public static Tool getTool(String code) {
        for (Tool tool : tools) {
            if (tool.getCode().equals(code)) {
                return tool;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param type
     * @param brand
     * @return returns the Tool object identified by the provided type and brand.
     */
    public static Tool getTool(String type, String brand) {
        for (Tool tool : tools) {
            if (tool.getType().equals(type) && tool.getBrand().equals(brand)) {
                return tool;
            }
        }
        return null;
    }

    /**
     * 
     * @return the array of Tools contained by this object.
     */
    public static Tool[] getTools() {
        return tools;
    }
}
