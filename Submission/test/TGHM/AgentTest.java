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
public class AgentTest {
    
    public AgentTest() {
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
     * Test of storeInDb method, of class Agent.
     */
    @Test
    public void testStoreInDb() throws Exception {
        System.out.println("storeInDb");
        Agent instance = new Agent("testAgent","agent@test.com","testagentuser","testagentpass","testsupplier");
        instance.storeInDb();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getContact method, of class Agent.
     */
    @Test
    public void testGetContact() {
        System.out.println("getContact");
        Agent instance = new Agent("testAgent","agent@test.com","testagentuser","testagentpass","testsupplier");
        String expResult = "agent@test.com";
        String result = instance.getContact();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getName method, of class Agent.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Agent instance = new Agent("testAgent","agent@test.com","testagentuser","testagentpass","testsupplier");
        String expResult = "testAgent";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAgentFoodSupplier method, of class Agent.
     */
    @Test
    public void testGetAgentFoodSupplier() {
        System.out.println("getAgentFoodSupplier");
        Agent instance = new Agent("tesAgent","agent@test.com","testagentuser","testagentpass","testsupplier");
        String expResult = "testsupplier";
        String result = instance.getAgentFoodSupplier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTotalDeliveries method, of class Agent.
     */
    @Test
    public void testGetTotalDeliveries() {
        System.out.println("getTotalDeliveries");
        Agent instance = new Agent("tesAgent","agent@test.com","testagentuser","testagentpass","testsupplier");
        int expResult = 0;
        int result = instance.getTotalDeliveries();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setAgentNumberOfOrdersAccepted method, of class Agent.
     */
    @Test
    public void testSetAgentNumberOfOrdersAccepted() {
        System.out.println("setAgentNumberOfOrdersAccepted");
        int agentNumberOfOrdersAccepted = 0;
        Agent instance = new Agent("tesAgent","agent@test.com","testagentuser","testagentpass","testsupplier");
        instance.setAgentNumberOfOrdersAccepted(agentNumberOfOrdersAccepted);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSuccesfullDeliveries method, of class Agent.
     */
    @Test
    public void testGetSuccesfullDeliveries() {
        System.out.println("getSuccesfullDeliveries");
        Agent instance = new Agent("tesAgent","agent@test.com","testagentuser","testagentpass","testsupplier");
        int expResult = 0;
        int result = instance.getSuccesfullDeliveries();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
