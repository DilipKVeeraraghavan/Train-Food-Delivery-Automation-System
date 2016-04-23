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
public class TrainTest {
    
    public TrainTest() {
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
     * Test of getTrainName method, of class Train.
     */
    @Test
    public void testGetTrainName() {
        System.out.println("getTrainName");
        Train instance = new Train();
        String expResult = "SRC";
        String result = instance.getTrainName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTrainName method, of class Train.
     */
    @Test
    public void testSetTrainName() {
        System.out.println("setTrainName");
        String trainName = "Rajdhani";
        Train instance = new Train();
        instance.setTrainName(trainName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTrainNumber method, of class Train.
     */
    @Test
    public void testGetTrainNumber() {
        System.out.println("getTrainNumber");
        Train instance = new Train();
        String expResult = "22807";
        String result = instance.getTrainNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTrainNumber method, of class Train.
     */
    @Test
    public void testSetTrainNumber() {
        System.out.println("setTrainNumber");
        String trainNumber = "22808";
        Train instance = new Train();
        instance.setTrainNumber(trainNumber);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTrainRoute method, of class Train.
     */
    @Test
    public void testGetTrainRoute() {
        System.out.println("getTrainRoute");
        Train instance = new Train();
        TrainRoute expResult = null;
        TrainRoute result = instance.getTrainRoute();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTrainRoute method, of class Train.
     */
    @Test
    public void testSetTrainRoute() {
        System.out.println("setTrainRoute");
        TrainRoute trainRoute = null;
        Train instance = new Train();
        instance.setTrainRoute(trainRoute);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
