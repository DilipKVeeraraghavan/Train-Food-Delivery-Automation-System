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
public class RestaurantTest {
    
    public RestaurantTest() {
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
     * Test of getRestaurantStations method, of class Restaurant.
     */
    @Test
    public void testGetRestaurantStations() {
        System.out.println("getRestaurantStations");
        ArrayList<RailwayStation> expResult = new ArrayList<>();
        expResult.add(new RailwayStation());
        expResult.add(new RailwayStation());
        ArrayList<FoodItem> flist = new ArrayList<>();
        flist.add(new FoodItem());
        flist.add(new FoodItem());
        Restaurant instance = new Restaurant(expResult,"testrestaurant",new Cert(),flist,"testresuser","testrespass","123456789");
        ArrayList<RailwayStation> result = instance.getRestaurantStations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRestaurantNumberOfStations method, of class Restaurant.
     */
    @Test
    public void testGetRestaurantNumberOfStations() {
        System.out.println("getRestaurantNumberOfStations");
        ArrayList<RailwayStation> list = new ArrayList<>();
        list.add(new RailwayStation());
        list.add(new RailwayStation());
        ArrayList<FoodItem> flist = new ArrayList<>();
        flist.add(new FoodItem());
        flist.add(new FoodItem());
        Restaurant instance = new Restaurant(list,"testrestaurant",new Cert(),flist,"testresuser","testrespass","123456789");
        int expResult = 2;
        int result = instance.getRestaurantNumberOfStations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setRestaurantNumberOfStations method, of class Restaurant.
     */
    @Test
    public void testSetRestaurantNumberOfStations() {
        System.out.println("setRestaurantNumberOfStations");
        int restaurantNumberOfStations = 3;
        ArrayList<RailwayStation> list = new ArrayList<>();
        list.add(new RailwayStation());
        list.add(new RailwayStation());
        list.add(new RailwayStation());
        ArrayList<FoodItem> flist = new ArrayList<>();
        flist.add(new FoodItem());
        flist.add(new FoodItem());
        Restaurant instance = new Restaurant(list,"testrestaurant",new Cert(),flist,"testresuser","testrespass","123456789");
        instance.setRestaurantNumberOfStations(restaurantNumberOfStations);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of storeInDb method, of class Restaurant.
     */
    @Test
    public void testStoreInDb() throws Exception {
        System.out.println("storeInDb");
        ArrayList<RailwayStation> list = new ArrayList<>();
        list.add(new RailwayStation());
        list.add(new RailwayStation());
        list.add(new RailwayStation());
        ArrayList<FoodItem> flist = new ArrayList<>();
        flist.add(new FoodItem());
        flist.add(new FoodItem());
        Restaurant instance = new Restaurant(list,"testrestaurant",new Cert(),flist,"testresuser","testrespass","123456789");
        instance.storeInDb();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
