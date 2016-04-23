/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TGHM;

import java.util.ArrayList;
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
public class FoodSupplierTest {
    
    public FoodSupplierTest() {
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
     * Test of getContact method, of class FoodSupplier.
     */
    @Test
    public void testGetContact() {
        System.out.println("getContact");
        FoodSupplier instance = new FoodSupplier();
        String expResult = "123456";
        String result = instance.getContact();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class FoodSupplier.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        FoodSupplier instance = new FoodSupplier();
        String expResult = "FoodChain";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getName method, of class FoodSupplier.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        FoodSupplier instance = new FoodSupplier();
        String expResult = "KFC";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }


    /**
     * Test of getUsername method, of class FoodSupplier.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        FoodSupplier instance = new FoodSupplier();
        String expResult = "KFC";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
