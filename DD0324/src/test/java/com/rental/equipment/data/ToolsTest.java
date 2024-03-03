/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rental.equipment.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ddevo
 */
public class ToolsTest {
    
    public ToolsTest() {
    }
    
    /**
     * Test of getTool method, of class Tools.
     */
    @Test
    public void testGetTool_String() {
        System.out.println("getTool");
        String code = "JAKD";
        Tool result = Tools.getTool(code);
        assertEquals("DeWalt", result.getBrand());

        System.out.println("ToolsTest.testGetTool_String() test complete.");        
    }

    /**
     * Test of getTool method, of class Tools.
     */
    @Test
    public void testGetTool_String_String() {
        System.out.println("getTool");
        String type = "Jackhammer";
        String brand = "DeWalt";
        Tool result = Tools.getTool(type, brand);
        assertEquals("JAKD", result.getCode());

        System.out.println("ToolsTest.testGetTool_String_String() test complete.");        
    }

    /**
     * Test of getTools method, of class Tools.
     */
    @Test
    public void testGetTools() {
        System.out.println("getTools");
        Tool[] result = Tools.getTools();
        assertEquals(4, result.length);

        System.out.println("ToolsTest.testGetTools() test complete.");        
    }
}
