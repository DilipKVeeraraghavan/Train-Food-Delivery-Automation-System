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
public class FoodChainTest {
    
    public FoodChainTest() {
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
     * Test of getRestaurantStations method, of class FoodChain.
     */
    @Test
    public void testGetRestaurantStations() {
        System.out.println("getRestaurantStations");
        //ArrayList<RailwayStation> stations,String name,Cert cert,ArrayList<FoodItem> menu,String user,String pass,String contact
        ArrayList<FoodItem> flist =  new ArrayList<>();
        flist.add(new FoodItem());
        flist.add(new FoodItem());
        ArrayList<RailwayStation> expResult = new ArrayList<>();
        expResult.add(new RailwayStation());
        FoodChain instance = new FoodChain(expResult,"testchain",null,flist,"testuser","testpass","123456");
        ArrayList<RailwayStation> result = instance.getRestaurantStations();
        assertEquals(expResult, result);
    }
    /**
     * Test of storeInDb method, of class FoodChain.
     */
    @Test
    public void testStoreInDb() throws Exception {
        System.out.println("storeInDb");
        ArrayList<FoodItem> flist =  new ArrayList<>();
        flist.add(new FoodItem());
        flist.add(new FoodItem());
        ArrayList<RailwayStation> expResult = new ArrayList<>();
        expResult.add(new RailwayStation());
        FoodChain instance =  new FoodChain(expResult,"testchain",new Cert(),flist,"testuser1","testpass","123456");
        instance.storeInDb();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
