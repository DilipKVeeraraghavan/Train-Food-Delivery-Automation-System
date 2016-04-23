/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TGHM;

import java.util.ArrayList;
import javax.naming.AuthenticationException;
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
public class TrainRouteTest {
    
    public TrainRouteTest() {
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
     * Test of getSuccess method, of class TrainRoute.
     */
    @Test
    public void testGetSuccess() throws AuthenticationException, UnableToConnectException {
        System.out.println("getSuccess");
        ManagementAuth ma =new ManagementAuth("root","awesome");
        TrainRoute instance = new TrainRoute(1,ma);
        int expResult = 0;
        int result = instance.getSuccess();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSno method, of class TrainRoute.
     */
    @Test
    public void testGetSno() throws AuthenticationException, UnableToConnectException {
        System.out.println("getSno");
        ManagementAuth ma =new ManagementAuth("root","awesome");
        TrainRoute instance = new TrainRoute(1,ma);
        String expResult = "1";
        String result = instance.getSno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getName method, of class TrainRoute.
     */
    @Test
    public void testGetName() throws AuthenticationException, UnableToConnectException {
        System.out.println("getName");
        ManagementAuth ma =new ManagementAuth("root","awesome");
        TrainRoute instance = new TrainRoute(1,ma);
        String expResult = "MAS - KOL";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStations method, of class TrainRoute.
     */
    @Test
    public void testGetStations() throws AuthenticationException, UnableToConnectException {
        System.out.println("getStations");
        ManagementAuth ma =new ManagementAuth("root","awesome");
        TrainRoute instance = new TrainRoute(1,ma);
        ArrayList<RailwayStation> expResult = null;
        ArrayList<RailwayStation> result = instance.getStations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTotalDeliveries method, of class TrainRoute.
     */
    @Test
    public void testGetTotalDeliveries() throws AuthenticationException, UnableToConnectException {
        System.out.println("getTotalDeliveries");
        ManagementAuth ma =new ManagementAuth("root","awesome");
        TrainRoute instance = new TrainRoute(1,ma);
        int expResult = 0;
        int result = instance.getTotalDeliveries();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of routeSucessfulDeliveries method, of class TrainRoute.
     */
    @Test
    public void testRouteSucessfulDeliveries() throws AuthenticationException, UnableToConnectException {
        System.out.println("routeSucessfulDeliveries");
        ManagementAuth ma =new ManagementAuth("root","awesome");
        TrainRoute instance = new TrainRoute(1,ma);
        int expResult = 0;
        int result = instance.routeSucessfulDeliveries();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
