/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TGHM;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DILIPKUMAR
 */
public class FoodItemTest {
    
    public FoodItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of equals method, of class FoodItem.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new FoodItem();
        FoodItem instance = new FoodItem();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getName method, of class FoodItem.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        FoodItem instance = new FoodItem();
        String expResult = "Roti";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPrice method, of class FoodItem.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        FoodItem instance = new FoodItem();
        int expResult = 5;
        int result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
