package TGHM;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.AuthenticationException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author THARUN
 */
public class MainTest 
{
    public static void nothing(String[] args)
    {
        
        RailwayStation s1 = new RailwayStation("Mumbai","1"),s2 = new RailwayStation("Chennai","2"),s3 = new RailwayStation("Mumbai","2"),s4 = new RailwayStation("Dehradun","3");
        FoodItem i1 = new FoodItem("Idly",25),i2 = new FoodItem("Dosa",20),i3 = new FoodItem("Vada",30);
        Cert cert = new Cert("red");
        
//        /*test 1*/
//        try 
//        {
//            ArrayList<RailwayStation> stations = new ArrayList<RailwayStation>();
//            ArrayList<FoodItem>       menu     = new ArrayList<FoodItem>();
//            menu.add(i2);
//            stations.add(s3);
//            Management.sendRegistrationRequest("user","pass","McD",cert,menu,stations,"FoodChain");
//        } 
//        catch (IllegalArgumentException ex) 
//        {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (UnableToConnectException ex) 
//        {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//        
//        /*test 2*/
//        try 
//        {
//            ArrayList<RailwayStation> stations = new ArrayList<RailwayStation>();
//            ArrayList<FoodItem>       menu     = new ArrayList<FoodItem>();
//            menu.add(i1);
//            stations.add(s1);
//            Management.sendRegistrationRequest("user","pass","McD",cert,menu,stations,"FoodChain");
//        } 
//        catch (IllegalArgumentException ex) 
//        {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (UnableToConnectException ex) 
//        {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        /*test 3*/
//        try 
//        {
//            ArrayList<RailwayStation> stations = new ArrayList<RailwayStation>();
//            ArrayList<FoodItem>       menu     = new ArrayList<FoodItem>();
//            menu.add(i1);
//            menu.add(i2);
//            stations.add(s2);
//            stations.add(s4);
//            Management.sendRegistrationRequest("user","pass","McD",cert,menu,stations,"FoodChain");
//        } 
//        catch (IllegalArgumentException ex) 
//        {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (UnableToConnectException ex) 
//        {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        /*test 4*/
//        try 
//        {
//            ArrayList<RailwayStation> stations = new ArrayList<RailwayStation>();
//            ArrayList<FoodItem>       menu     = new ArrayList<FoodItem>();
//            menu.add(i1);
//            menu.add(i2);
//            stations.add(s2);
//            Management.sendRegistrationRequest("user","pass","McD",cert,menu,stations,"FoodChain");
//        } 
//        catch (IllegalArgumentException ex) 
//        {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (UnableToConnectException ex) 
//        {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
        

        /*test 5*/
//        try 
//        {
//            ArrayList<RailwayStation> stations = new ArrayList<RailwayStation>();
//            ArrayList<FoodItem>       menu     = new ArrayList<FoodItem>();
//            menu.add(i2);
//            menu.add(i3);
//            stations.add(s2);
//            stations.add(s1);
//            Management.sendRegistrationRequest("usernameeight","pass","McD",cert,"FoodChain","9192939495","Agent","Agents cell","Agentuserseven","AgentPassseven");
//        } 
//        catch (IllegalArgumentException ex) 
//        {
//            System.out.println(ex.getMessage());
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (UnableToConnectException ex) 
//        {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        /*test 6*/
//        try 
//        {
//            ManagementAuth ma = new ManagementAuth("root","awesome");
//            Management.rejectRegistration(ma,"usernamefour");
//            
//        } 
//        catch (IllegalArgumentException ex) 
//        {
//            System.out.println(ex.getMessage());
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (UnableToConnectException ex) 
//        {
//            System.out.println(ex.getMessage());
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (AuthenticationException ex) 
//        {
//            System.out.println(ex.getMessage());    
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }

          /*test 7*/
//        try 
//        {
//            ManagementAuth ma = new ManagementAuth("root","awesome");
//            Management.rejectRegistration(ma,"usernamefour");
//            
//        } 
//        catch (IllegalArgumentException ex) 
//        {
//            System.out.println(ex.getMessage());
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (UnableToConnectException ex) 
//        {
//            System.out.println(ex.getMessage());
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        catch (AuthenticationException ex) 
//        {
//            System.out.println(ex.getMessage());    
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
    
        /*test 7*/
        try 
        {
            ManagementAuth ma = new ManagementAuth("root","awesome");
            ArrayList<FoodSupplier> fs = Management.getRegistrants(ma);
            for(int i=0;i<fs.size();i++)
            System.out.println(fs.get(i).getName()+"\n");
        } 
        catch (IllegalArgumentException ex) 
        {
            System.out.println(ex.getMessage());
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (UnableToConnectException ex) 
        {
            System.out.println(ex.getMessage());
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (AuthenticationException ex) 
        {
            System.out.println(ex.getMessage());    
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
}
