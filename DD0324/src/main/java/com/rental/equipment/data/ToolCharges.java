/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rental.equipment.data;

/**
 * The ToolCharges object holds an array of ToolCharge objects. 
 * 
 * @author ddevo
 */
public class ToolCharges {
    
    private static ToolCharge[] charges = null;
    
    /** 
     * Initializes the ToolCharge array with the required values to be used 
     * by the program.
     */
    private static void initializeToolCharges() {
        charges = new ToolCharge[3];
        charges[0] = new ToolCharge("Ladder", 1.99, true, true, false);
        charges[1] = new ToolCharge("Chainsaw", 1.49, true, false, true);
        charges[2] = new ToolCharge("Jackhammer", 2.99, true, false, false);
    }
    
    /**
     * @return the ToolCharge array contained by this ToolCharges object. 
     */
    public static ToolCharge[] getCharges() {
        if (charges == null) {
            initializeToolCharges();
        }
        
        return charges;
    }
    
    /**
     * @param toolType
     * @return the ToolCharge object associated with the provided toolType.
     */
    public static ToolCharge getCharge(String toolType) {
        if (charges == null) {
            initializeToolCharges();
        }
        
        for (ToolCharge charge : charges) {
            if (charge.getToolType().equals(toolType)) {
                return charge;
            }
        }
        return null;
    }
}
