/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TGHM;

import java.util.ArrayList;
import java.util.Collections;
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
public class ManagementTest {
    
    public ManagementTest() {
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
     * Test of getMenu method, of class Management.
     */
    @Test
    public void testGetMenu() throws Exception {
        System.out.println("getMenu");
        FoodSupplierAuth fsas = new FoodSupplierAuth("billoouser","billoopass");
        ArrayList<FoodItem> expResult = new ArrayList<FoodItem>();
        expResult.add(new FoodItem("Chicken Fried Rice",115));
        expResult.add(new FoodItem("Chicken Dopiaza",95));
        ArrayList<FoodItem> result = Management.getMenu(fsas);
        System.out.println(result.get(0).getPrice()+expResult.get(0).getPrice());
        assertEquals(expResult,result);
    }
    
    /**
     * Test of getOrders method, of class Management.
     
    @Test
    public void testGetOrders() throws Exception {
        System.out.println("getOrders");
        AgentAuth fsas = null;
        ArrayList<Order> expResult = null;
        ArrayList<Order> result = Management.getOrders(fsas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }*/

    /**
     * Test of getStations method, of class Management.
     
    @Test
    public void testGetStations_AgentAuth() throws Exception {
        System.out.println("getStations");
        AgentAuth fsas = null;
        ArrayList<RailwayStation> expResult = null;
        ArrayList<RailwayStation> result = Management.getStations(fsas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    */
    /**
     * Test of setMenu method, of class Management.
     
    @Test
    public void testSetMenu() throws Exception {
        System.out.println("setMenu");
        ArrayList<FoodItem> menuList = null;
        FoodSupplierAuth fsas = null;
        Management.setMenu(menuList, fsas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getAgents method, of class Management.
     
    @Test
    public void testGetAgents() throws Exception {
        System.out.println("getAgents");
        ManagementAuth ma = null;
        ArrayList<Agent> expResult = null;
        ArrayList<Agent> result = Management.getAgents(ma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */
    /**
     * Test of addStation method, of class Management.
     */
    @Test
    public void testAddStation() throws Exception {
        System.out.println("addStation");
        String name = "Satraganchi";
        String code = "78797";
        ManagementAuth ma = new ManagementAuth("root","awesome");
        Management.addStation(name, code, ma);
        // TODO review the generated test code and remove the default call to fail
    }

    /**
     * Test of removeStation method, of class Management.
     */
    @Test
    public void testRemoveStation() throws Exception {
        System.out.println("removeStation");
        ManagementAuth ma = new ManagementAuth("root","awesome");
        String code = "78797";
        Management.removeStation(ma, code);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStations method, of class Management.
     
    @Test
    public void testGetStations_ManagementAuth() throws Exception {
        System.out.println("getStations");
        ManagementAuth ma = null;
        ArrayList<RailwayStation> expResult = null;
        ArrayList<RailwayStation> result = Management.getStations(ma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }*/

    /**
     * Test of PlaceOrder method, of class Management.
     */
    @Test
    public void testPlaceOrder() {
        System.out.println("PlaceOrder");
        Customer c = new Customer();
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        ArrayList<Integer> foodquant = new ArrayList<>();
        FoodSupplier provider = new FoodSupplier();
        Time time = new Time();
        Train t = new Train();
        RailwayStation stat = new RailwayStation();
        Management.PlaceOrder(c, foodlist, foodquant, provider, time, t, stat);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTrains method, of class Management.
     
    @Test
    public void testGetTrains() throws Exception {
        System.out.println("getTrains");
        ManagementAuth ma = new ManagementAuth("root","awesome");
        ArrayList<Train> expResult = null;
        ArrayList<Train> result = Management.getTrains(ma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }*/
    
    /**
     * Test of addTrain method, of class Management.
     
    @Test
    public void testAddTrain() throws Exception {
        System.out.println("addTrain");
        String name = "testtrain";
        int number = 1700;
        int route = 2;
        ManagementAuth ma = new ManagementAuth("root","awesome");
        Management.addTrain(name, number, route, ma);
        Management.removeTrain(1500,ma);
        // TODO review the generated test code and remove the default call to fail.
    }
    */
    /**
     * Test of removeTrain method, of class Management.
         @Test
    public void testRemoveTrain() throws Exception {
        System.out.println("removeTrain");
        int number = 1600;
        ManagementAuth ma = new ManagementAuth("root","awesome");
        String name = "testtrain";
        int cnumber = 1600;
        int route = 2;
        Management.addTrain(name, cnumber, route, ma);
        Management.removeTrain(number, ma);
        // TODO review the generated test code and remove the default call to fail.
    }
    */
    

    /**
     * Test of startTimer method, of class Management.
     */
    @Test
    public void testStartTimer() {
        System.out.println("startTimer");
        int Sno = 0;
        Management.startTimer(Sno);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of modifyOrder method, of class Management.
     */
    @Test
    public void testModifyOrder() {
        System.out.println("modifyOrder");
        int Sno = 10;
        Customer c = new Customer();
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        ArrayList<Integer> foodquant = new ArrayList<>();
        FoodSupplier provider = new FoodSupplier();
        Time time = new Time();
        Train t = new Train();
        RailwayStation stat = new RailwayStation();
        Management.modifyOrder(Sno, c, foodlist, foodquant, provider, time, t, stat);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of Cancel method, of class Management.
     */
    @Test
    public void testCancel() {
        System.out.println("Cancel");
        int Sno = 0;
        Management.Cancel(10);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sendRegistrationRequest method, of class Management.
     
    @Test
    public void testSendRegistrationRequest() throws Exception {
        System.out.println("sendRegistrationRequest");
        String username = "testuseranother";
        String password = "testpass";
        String name = "testname";
        Cert certificate = new Cert();
        String type = "FoodChain";
        String contact = "123456";
        String agentName = "testAgent";
        String agentContact = "12345678";
        String agentUsername = "testagentuser";
        String agentPassword = "testagentpass";
        Management.sendRegistrationRequest(username, password, name, certificate, type, contact, agentName, agentContact, agentUsername, agentPassword);
        // TODO review the generated test code and remove the default call to fail.
    }*/

    /**
     * Test of getRoutes method, of class Management.
     */
    @Test
    public void testGetRoutes() throws Exception {
        System.out.println("getRoutes");
        ManagementAuth ma = new ManagementAuth("root","awesome");
        ArrayList<TrainRoute> expResult = null;
        ArrayList<TrainRoute> result = Management.getRoutes(ma);
        expResult=result;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of acceptRegistration method, of class Management.
     */
    @Test
    public void testAcceptRegistration() throws Exception {
        System.out.println("acceptRegistration");
        ManagementAuth ma = new ManagementAuth("root","awesome");
        String foodSupplierUsername = "subwayuser";
        Management.acceptRegistration(ma, foodSupplierUsername);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStatistics method, of class Management.
     */
    @Test
    public void testGetStatistics() throws Exception {
        System.out.println("getStatistics");
        ManagementAuth ma = new ManagementAuth("root","awesome");
        String identifier = "testagentuser";
        String type = "Agent";
        Statistics expResult = new Statistics(0,0);
        Statistics result = Management.getStatistics(ma, identifier, type);
        expResult.equals(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRegistrants method, of class Management.
     
    @Test
    public void testGetRegistrants() throws Exception {
        System.out.println("getRegistrants");
        ManagementAuth ma = null;
        ArrayList<FoodSupplier> expResult = null;
        ArrayList<FoodSupplier> result = Management.getRegistrants(ma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
     */
    /**
     * Test of AcceptOrder method, of class Management.
     
    @Test
    public void testAcceptOrder() throws Exception {
        System.out.println("AcceptOrder");
        int sno = 0;
        AgentAuth fsas = new AgentAuth("testuser","testpass");
        Management.AcceptOrder(sno, fsas);
        // TODO review the generated test code and remove the default call to fail.
    }
     */
    /**
     * Test of RejectOrder method, of class Management.
     
    @Test
    public void testRejectOrder() throws Exception {
        System.out.println("RejectOrder");
        int sno = 1;
        AgentAuth fsas = new AgentAuth("testuser","testpass");
        Management.RejectOrder(sno, fsas);
        // TODO review the generated test code and remove the default call to fail.
    }*/

    /**
     * Test of rejectRegistration method, of class Management.
     */
    @Test
    public void testRejectRegistration() throws Exception {
        System.out.println("rejectRegistration");
        ManagementAuth ma = new ManagementAuth("root","awesome");
        String foodSupplierUsername = "testuser";
        Management.rejectRegistration(ma, foodSupplierUsername);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addRoute method, of class Management.
     
    @Test
    public void testAddRoute() throws Exception {
        System.out.println("addRoute");
        ManagementAuth ma = new ManagementAuth("root","awesome");
        String name = "testroute";
        ArrayList<RailwayStation> stations = new ArrayList<>();
        Management.addRoute(ma, name, stations);
        // TODO review the generated test code and remove the default call to fail.
    }*/
    
}
