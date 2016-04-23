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
public class ManagementAuthTest {
    
    public ManagementAuthTest() {
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
     * Test of getUsername method, of class ManagementAuth.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        ManagementAuth instance = new ManagementAuth("root","awesome");
        String expResult = "root";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkPassword method, of class ManagementAuth.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String checkPass = "awesome";
        ManagementAuth instance = new ManagementAuth("root","awesome");
        boolean expResult = true;
        boolean result = instance.checkPassword(checkPass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
