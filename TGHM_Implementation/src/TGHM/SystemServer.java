
package TGHM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.AuthenticationException;

public class SystemServer {
    private static Scanner input,get;
    private static int choices;
    private static FoodItem food;
    private static FoodSupplier provider;
    private static Customer neu;
    private static Time timeofdelivery;
    private static Train t;
    private static RailwayStation stat;
    private static ArrayList<FoodItem> foodlist =new ArrayList<FoodItem>();
    private static ArrayList<Integer> foodquant =new ArrayList<Integer>();
    
    public static void mains(String[] args) throws Exception{
        System.out.println("Please enter your choice :"
                + "\n1. Register"
                + "\n2. Place Order : dummy customer"  
                + "\n3. Modify Order"
                + "\n4. Cancel Order"
                );
        
        input = new Scanner(System.in);
    
        neu = new Customer();
        food =new FoodItem("Rice");
        foodlist.add(food);
        foodquant.add(5);
        food =new FoodItem();
        foodlist.add(food);
        foodquant.add(3);
        food =new FoodItem("Dal");
        foodlist.add(food);
        foodquant.add(2);
        food =new FoodItem("Parotta");
        foodlist.add(food);
        foodquant.add(8);
        
        stat = new RailwayStation();
        t =new Train();
        
        provider = new FoodSupplier();
        timeofdelivery = new Time();
        
        choices = input.nextInt();
        switch(choices){
            case 1: RegisterCustomer();
                    break;
            case 2: Management.PlaceOrder(neu,foodlist,foodquant,provider,timeofdelivery,t,stat);
                    break;
            case 3: Management.modifyOrder(12,neu,foodlist,foodquant,provider,timeofdelivery,t,stat);
                    break;
        }
        
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

    
    
    private static void RegisterCustomer() throws Exception{
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        try
        {
        get = new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stt = con.createStatement();  
        stt.execute("USE tghm");
        System.out.println("Please enter your Username :");
        String username = get.nextLine();
        
        System.out.println("Please enter your Contact :");
        String contact  = get.nextLine();
        
        System.out.println("Please enter your Password :");
        String Password = get.nextLine();    
        stt.execute("INSERT INTO customer (Contact,Username,Password) VALUES('"+contact+"','"+username+"','"+Password+"')");
        stt.close();
        con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
