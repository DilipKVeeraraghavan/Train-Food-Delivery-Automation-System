/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TGHM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.naming.AuthenticationException;

public class TrainRoute {

        private String Sno;
	private String routeName;
	private ArrayList<RailwayStation> routeRailwayStations;
	private int routeSuccessfulDeliveries;
	private int routeTotalDeliveries;
        public int getSuccess()
        {
            return routeSuccessfulDeliveries;
        }
        public String getSno()
        {
            return Sno;
        }

        TrainRoute(int routeSno,ManagementAuth ma) throws AuthenticationException, UnableToConnectException 
        {
            Sno = Integer.toString(routeSno);
            DbConnect conn = null;
            ResultSet res  = null;
            String save = "TrainRouteSave";            
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT "+save+";");
                conn.runQuery("USE tghm");
                
                /*Authenticate*/
                res = conn.runQuery("SELECT * FROM  management WHERE Username= '"+ma.getUsername()+"';");
                if(!res.next())
                {
                    throw new AuthenticationException("Invalid Username");
                }
                else if( !ma.checkPassword( res.getString("Password") ) )
                {
                    throw new AuthenticationException("Username and password don't match");
                }
                
                
                /*Get route*/
                res = conn.runQuery("SELECT * FROM  trainroute WHERE Sno = '"+routeSno+"';");
                res.next();
                routeName = res.getString("Name");
                routeSuccessfulDeliveries = Integer.parseInt(res.getString("SuccessNumber"));
                routeTotalDeliveries = Integer.parseInt(res.getString("TotalNumber"));
                String stationsString = res.getString("Stations");
                ArrayList<String> split= new ArrayList<>(Arrays.asList(stationsString.split(",")));
                for (String split1 : split) 
                {
                    RailwayStation rs = new RailwayStation(Integer.parseInt(split1),ma);
                }
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO "+save+";");
                } 
                catch (SQLException ex1) 
                {
                    
                }
                ex.printStackTrace();
                throw new UnableToConnectException("Unable to connect");
            }
            finally
            {
                try 
                {
                    /*Close connection*/
                    if(res!=null)
                    res.close();
                    if(conn!=null)
                    conn.close();
                } 
                catch (SQLException ex) 
                {
                    
                }
            }
        }
        
        public String getName()
        {
            return routeName;
        }
        
        public ArrayList<RailwayStation> getStations()
        {
            return routeRailwayStations;
        }
        
        public int getTotalDeliveries()
        {
            return routeTotalDeliveries;
        }
        
        public int routeSucessfulDeliveries()
        {
            return routeSuccessfulDeliveries;
        }

        
//        public TrainRoute(String name,ArrayList<RailwayStation> stations,int sucess,int total)
//        {
//            routeName                 = name;
//            routeRailwayStations      = stations;
//            routeSuccessfulDeliveries = sucess;
//            routeTotalDeliveries      = total;
//            Sno                       = "-1";
//        }
        
         public TrainRoute(String name,ArrayList<RailwayStation> stations,int sucess,int total,String sno)
        {
            routeName                 = name;
            routeRailwayStations      = stations;
            routeSuccessfulDeliveries = sucess;
            routeTotalDeliveries      = total;
            Sno                       = sno;
        }
        
        
     

}