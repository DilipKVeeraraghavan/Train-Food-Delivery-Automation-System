/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TGHM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.naming.AuthenticationException;
import javax.swing.JOptionPane;

/**
 *
 * @author DILIPKUMAR
 * 
 */
public abstract class Management {
    public static void setStations(ArrayList<RailwayStation> stations,AgentAuth fsas) throws AuthenticationException, UnableToConnectException,IllegalArgumentException
    {
            DbConnect conn = null;
            ResultSet res  = null;
            
            try 
            {
                
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveTwo;");
                conn.runQuery("USE tghm");
                String stationsString="";
                
                /*Authenticate*/
                res = conn.runQuery("SELECT * FROM  agent WHERE Username= '"+fsas.getUsername()+"';");
                if(!res.next())
                {
                    throw new AuthenticationException("Invalid Username");
                }
                else if( !fsas.checkPassword( res.getString("Password") ) )
                {
                    throw new AuthenticationException("Username and password dont match");
                }
                String user =  res.getString("FoodSupplierUsername");
                
                /*Check if stations have valid code*/
                for(int i=0;i<stations.size();i++)
                {
                    res = conn.runQuery("SELECT * FROM railwaystation WHERE Code= '"+stations.get(i).getCode()+"';");
                    if(!res.next())
                    {
                        throw new IllegalArgumentException("Invalid Code");
                    }
                    stationsString = stationsString+stations.get(i).getCode()+",";
                }
                
                /*Finally Store*/
                conn.runUpdate("UPDATE foodsupplier SET Stations='"+stationsString+"' WHERE Username='"+user+"';");
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveTwo;");
                } 
                catch (SQLException ex1) 
                {
                    
                }
                ex.printStackTrace();
                throw new UnableToConnectException("Unable to connect");
            }
            catch (IllegalArgumentException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveTwo;");
                } 
                catch (SQLException ex1) 
                {
                    
                }
                ex.printStackTrace();
                throw ex;
            }
            finally
            {
                try 
                {
                    /*Close connection*/
                    if(res!=null)
                    res.close();
                    conn.close();
                } 
                catch (SQLException ex) 
                {
                    
                }
            }        
    }
    
    
    public static ArrayList<FoodItem> getMenu(FoodSupplierAuth fsas) throws UnableToConnectException, AuthenticationException
    {
        ArrayList<FoodItem> menu =  new ArrayList<>();
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getMenusave";
            
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT "+save+";");
                conn.runQuery("USE tghm");
                ArrayList<String> split = new ArrayList<>();
                String list="";
                
                /*Authenticate*/
                res = conn.runQuery("SELECT * FROM  foodsupplier WHERE Username= '"+fsas.getUsername()+"';");
                if(!res.next())
                {
                    throw new AuthenticationException("Invalid Username");
                }
                else if( !fsas.checkPassword( res.getString("Password") ) )
                {
                    throw new AuthenticationException("Username and password dont match");
                }
                
                /*Get food items*/
                list = res.getString("Menu");
                if(!list.equals(""))
                {
                    split = new ArrayList<String>(Arrays.asList(list.split(",")));
                }
                else
                {
                    split = new ArrayList<>();
                }
                for(int i=0;i<split.size();i++)
                {
                    int sno = Integer.parseInt(split.get(i));
                    FoodItem fi = new FoodItem(sno);
                    menu.add(fi);
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
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
        return menu;
    }
    public static ArrayList<Order> getOrders(AgentAuth fsas) throws UnableToConnectException, AuthenticationException
    {
        ArrayList<Order> orders =  new ArrayList<>();
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getStationsave";
            
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT "+save+";");
                conn.runQuery("USE tghm");
                ArrayList<String> split;
                String fs="";
                
                /*Authenticate*/
                res = conn.runQuery("SELECT * FROM  agent WHERE Username= '"+fsas.getUsername()+"';");
                if(!res.next())
                {
                    throw new AuthenticationException("Invalid Username");
                }
                else if( !fsas.checkPassword( res.getString("Password") ) )
                {
                    throw new AuthenticationException("Username and password dont match");
                }
                fs = res.getString("FoodSupplierUsername");
                
                /*Get orders*/                
                res = conn.runQuery("SELECT * FROM  orderdetails WHERE FoodSupplier= '"+fs+"';");
                while(res.next())
                {
                    Order order = new Order(Integer.parseInt(res.getString("Sno")),res.getString("TrainNumber"),res.getString("DeliveryStation"),res.getString("FoodItems"),res.getString("Status"),"",res.getString("TimeOfDelivery"),res.getString("CustomerUserName"));
                    orders.add(order);
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
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
        return orders;
    }
    public static ArrayList<RailwayStation> getAllStations(AgentAuth aa) throws AuthenticationException, UnableToConnectException
    {
        ArrayList<RailwayStation> stations =  new ArrayList<>();
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getStationssave";
            
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT "+save+";");
                conn.runQuery("USE tghm");
                
                /*Authenticate*/
                res = conn.runQuery("SELECT * FROM  agent WHERE Username= '"+aa.getUsername()+"';");
                if(!res.next())
                {
                    throw new AuthenticationException("Invalid Username");
                }
                else if( !aa.checkPassword( res.getString("Password") ) )
                {
                    throw new AuthenticationException("Username and password don't match");
                }
                
                /*Add stations to list*/
                res = conn.runQuery("SELECT * FROM  railwaystation;");
                while(res.next())
                {
                    RailwayStation station = new RailwayStation(res.getString("Name"),res.getString("Code"));
                    stations.add(station);
                }
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                ex.printStackTrace();
                try 
                {
                    conn.runQuery("ROLLBACK TO "+save+";");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
        return stations;
    }
    public static ArrayList<RailwayStation> getStations(AgentAuth fsas) throws UnableToConnectException, AuthenticationException
    {
        ArrayList<RailwayStation> stations =  new ArrayList<>();
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getStationsave";
            
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT "+save+";");
                conn.runQuery("USE tghm");
                ArrayList<String> split;
                String list;
                
                /*Authenticate*/
                res = conn.runQuery("SELECT * FROM  agent WHERE Username= '"+fsas.getUsername()+"';");
                if(!res.next())
                {
                    throw new AuthenticationException("Invalid Username");
                }
                else if( !fsas.checkPassword( res.getString("Password") ) )
                {
                    throw new AuthenticationException("Username and password dont match");
                }
                
                /*Get stations*/                
                String fs = res.getString("FoodSupplierUsername");
                res = conn.runQuery("SELECT * FROM  foodsupplier WHERE Username= '"+fs+"';");
                list = res.getString("Stations");
                if(!list.equals(""))
                {
                    split = new ArrayList<>(Arrays.asList(list.split(",")));
                }
                else
                {
                    split = new ArrayList<>();
                }
                for(int i=0;i<split.size();i++)
                {
                    String code = split.get(i);
                    RailwayStation rs = new RailwayStation(code);
                    stations.add(rs);
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
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
        return stations;
    }
    
    public static void setMenu(ArrayList<FoodItem> menuList,FoodSupplierAuth fsas) throws UnableToConnectException, AuthenticationException
        {
            DbConnect conn = null;
            ResultSet res  = null;
            
            try 
            {
                int i,numberOfItems = menuList.size(),foodIndex,supplierIndex;
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveTwo;");
                conn.runQuery("USE tghm");
                String menu="";
                
                /*Authenticate*/
                res = conn.runQuery("SELECT * FROM  foodsupplier WHERE Username= '"+fsas.getUsername()+"';");
                if(!res.next())
                {
                    throw new AuthenticationException("Invalid Username");
                }
                else if( !fsas.checkPassword( res.getString("Password") ) )
                {
                    throw new AuthenticationException("Username and password dont match");
                } 
                else if( res.getString("Status").equals("Unreviewed") )
                {
                    throw new AuthenticationException("Your status is Unreviewed Please wait for management to review and accept before uploading menu data");
                }
                else if( res.getString("Status").equals("Rejected") )
                {
                    throw new AuthenticationException("Your status is Rejected,Please contact Management");
                }
                supplierIndex = Integer.parseInt( res.getString("Sno") );
                
                /*Remove current menu*/
                conn.runUpdate("DELETE FROM fooditem WHERE Supplier='"+supplierIndex+"';");
                
                /*Store menu items in db*/
                res = ( conn.runQuery("SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'tghm' AND   TABLE_NAME   = 'fooditem';") );
                if( !res.next() )
                {
                    foodIndex = 1;
                }
                else
                {
                    foodIndex = Integer.parseInt( res.getString("AUTO_INCREMENT") );
                }
                for(i = 0; i < numberOfItems; i++ )
                {
                    /*Store menu item in db and increment menu increment*/
                    conn.runUpdate("INSERT INTO fooditem (Name,Price,Supplier) VALUES ('"+menuList.get(i).getName()+"','"+menuList.get(i).getPrice()+"','"+supplierIndex+"')");
                    menu = menu+(foodIndex+i)+",";
                }
                
                /*Set menu in table*/
                conn.runUpdate("UPDATE foodsupplier SET menu='"+menu+"' WHERE Username='"+fsas.getUsername()+"';");     
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveTwo;");
                } 
                catch (SQLException ex1) 
                {
                    
                }
                ex.printStackTrace();
                throw new UnableToConnectException("Unable to connect");
            } 
            catch (InstantiationException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveTwo;");
                } 
                catch (SQLException ex1) 
                {
                    
                }
                ex.printStackTrace();
                throw new UnableToConnectException("Unable to connect");
            } 
            catch (IllegalAccessException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveTwo;");
                } 
                catch (SQLException ex1) 
                {
                    
                }
                ex.printStackTrace();
                throw new UnableToConnectException("Unable to connect");
            } 
            catch (SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveTwo;");
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
                    conn.close();
                } 
                catch (SQLException ex) 
                {
                    
                }
            }
        }
    public static ArrayList<Agent> getAgents(ManagementAuth ma) throws AuthenticationException, UnableToConnectException,IllegalArgumentException
    {
        ArrayList<Agent> agents =  new ArrayList<>();
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getStationssave";
            
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
                
                /*Add agents to list*/
                res = conn.runQuery("SELECT Name,SucessOrders,TotalOrders,FoodSupplierUsername,Username,Contact FROM  agent;");
                while(res.next())
                {
                    Agent agent = new Agent(res.getString("Name"),res.getString("Contact"),res.getString("Username"),"",res.getString("FoodSupplierUsername"));
                    agents.add(agent);
                }
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                ex.printStackTrace();
                try 
                {
                    conn.runQuery("ROLLBACK TO "+save+";");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
        return agents;
    }
    
    public static void addStation(String name,String code,ManagementAuth ma) throws AuthenticationException, UnableToConnectException,IllegalArgumentException
    {
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getStationssave";
            
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
                
                /*Check if code already exists*/
                res = conn.runQuery("SELECT * FROM  railwaystation WHERE Code= '"+code+"';");
                if(res.next())
                {
                    throw new IllegalArgumentException("Station code already exists");
                }
                
                /*Add station*/
                conn.runUpdate("INSERT  INTO railwaystation (Name,Code) VALUES ('"+name+"','"+code+"');");
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO "+save+";");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
    
    public static void removeStation(ManagementAuth ma,String code) throws AuthenticationException, UnableToConnectException,IllegalArgumentException
    {
        
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "removeStationSave";
            
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
                
                /*Check if code already exists*/
                res = conn.runQuery("SELECT * FROM  railwaystation WHERE Code= '"+code+"';");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Station code doesn't exists");
                }
                
                /*Check if the station is not present in any route*/
                res = conn.runQuery("SELECT * FROM  trainroute;");
                while(res.next())
                {
                    String stationList = res.getString("Stations");
                    ArrayList<String> split = new ArrayList<>(Arrays.asList(stationList.split(",")));
                    if(split.contains(code))
                    {
                        throw new IllegalArgumentException("The station is present in some route,Please remove the route before removing this station");
                    }
                }
                
                /*Remove station*/
                conn.runUpdate("DELETE FROM  railwaystation WHERE Code='"+code+"';");
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO "+save+";");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
    
    public static ArrayList<RailwayStation> getStations(ManagementAuth ma) throws AuthenticationException, UnableToConnectException,IllegalArgumentException
    {
        ArrayList<RailwayStation> stations = new ArrayList<>();
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getStationssave";
            
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
                
                
                /*Get List*/
                res = conn.runQuery("SELECT * FROM  railwaystation;");
                while(res.next())
                {
                    RailwayStation rs = new RailwayStation(res.getString("Name"),res.getString("Code"));
                    stations.add(rs);
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
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
        
        return stations;
    }
    
    public static void PlaceOrder(Customer c,ArrayList<FoodItem> foodlist,ArrayList<Integer> foodquant,FoodSupplier provider,Time time,Train t,RailwayStation stat){
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        try
        {
            String orderdetails ="";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            
            orderdetails = "INSERT INTO orderdetails(TrainNumber,DeliveryStation,TimeOfDelivery,FoodItems,Status,FoodSupplier,CustomerUserName) VALUES('"+t.getTrainNumber()+"','"+stat.getStationCode()+"','"+time.gethour()+
                    ":"+time.getminute()+","+time.getday()+"/"+time.getmonth()+"/"+time.getyear()+"','";
            
            for(int i=0;i<foodlist.size();i++)
            {
                orderdetails+=foodlist.get(i).getName()+"-"+foodquant.get(i)+" ";
            }
            
            orderdetails+="','UnAccepted','";
            orderdetails+=(provider.getName()+"','");
            orderdetails+=(c.getName()+"')");
            stt.execute("USE tghm");
            
            stt.execute(orderdetails);
            stt.close();
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Train> getTrains(ManagementAuth ma) throws AuthenticationException, UnableToConnectException,IllegalArgumentException
    {
        ArrayList<Train> trains = new ArrayList<Train>();
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getTrainSave";
            
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
                
                
                /*Get List*/
                res = conn.runQuery("SELECT * FROM  train;");
                while(res.next())
                {
                    int routeSno = Integer.parseInt(res.getString("Route"));
                    TrainRoute route = new TrainRoute(routeSno,ma);
                    Train train = new Train(res.getString("Name"),res.getString("Number"),route);
                    trains.add(train);
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
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
        
        return trains;
    }
    
    public static void removeTrain(int number,ManagementAuth ma) throws AuthenticationException, UnableToConnectException,IllegalArgumentException
    {
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "removeTrainSave";
            
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
                
                
                /*Check if given train number exists*/
                res = conn.runQuery("SELECT * FROM  train WHERE Number= '"+number+"';");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Train Number doesnt exists");
                }
                
                /*Remove table*/
                conn.runUpdate("REMOVE FROM train WHERE Number ='"+number+"';");
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO "+save+";");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
    public static void addTrain(String name,int number,int route,ManagementAuth ma) throws UnableToConnectException, AuthenticationException,IllegalArgumentException
    {
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "addTrainSave";
            
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
                
                /*Check if number of train route is valid*/
                res = conn.runQuery("SELECT * FROM  trainroute WHERE Sno= '"+route+"';");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Invalid train route number");
                }
                
                /*Check if given train number already exists*/
                res = conn.runQuery("SELECT * FROM  train WHERE Number= '"+number+"';");
                if(res.next())
                {
                    throw new IllegalArgumentException("Train Number already exists");
                }
                
                /*Add to table*/
                conn.runUpdate("INSERT INTO train (Number,Route,Name) VALUES ('"+number+"','"+route+"','"+name+"');");
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO "+save+";");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
    
    public static void startTimer(int Sno){
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                try
                {
                    String orderdetails ="";
                    String status="";
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement stt = con.createStatement();
                    
                    stt.execute("USE tghm");
                    
                    String query ="SELECT Status FROM orderdetails WHERE Sno ="+Sno;
                    
                    ResultSet rs =stt.executeQuery(query);
                    while(rs.next()){
                        status = rs.getString("Status");
                        if(status.equals("Accepted")){
                        }
                        else if(status.equals("UnAccepted")){
                            stt.execute("UPDATE orderdetails SET Status='Rejected' WHERE Sno="+Sno);
                        }
                    }
                    stt.close();
                    con.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, 
        1000*60*2
        );
    }
    
    public static void modifyOrder(int Sno,Customer c,ArrayList<FoodItem> foodlist,ArrayList<Integer> foodquant,FoodSupplier provider,Time time,Train t,RailwayStation stat){
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        
        try
        {
            String orderdetails = "";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            
            stt.execute("USE tghm");
            orderdetails = "UPDATE orderdetails SET TrainNumber='"+t.getTrainNumber()+"',DeliveryStation='"+stat.getStationCode()+"',TimeOfDelivery='"+time.gethour()+
                    ":"+time.getminute()+","+time.getday()+"/"+time.getmonth()+"/"+time.getyear()+"',FoodItems='";
            
            for(int i=0;i<foodlist.size();i++)
            {
                orderdetails+=foodlist.get(i).getName()+"-"+foodquant.get(i)+" ";
            }
            
            orderdetails+="',Status='UnAccepted'"+",FoodSupplier='";
            orderdetails+=(provider.getName()+"',");
            orderdetails+="CustomerUserName='"+c.getName()+"' WHERE Sno="+Sno;

            stt.execute(orderdetails);
            stt.close();
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void Cancel(int Sno){
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        
        try
        {
            String orderdetails = "";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            
            stt.execute("USE tghm");
            stt.execute("DELETE FROM orderdetails WHERE Sno="+Sno);
            stt.execute(orderdetails);
            stt.close();
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    } 
   
        
    
    public static void sendRegistrationRequest(String username,String password,String name,Cert certificate,String type,String contact,String agentName,String agentContact,String agentUsername,String agentPassword)throws IllegalArgumentException,UnableToConnectException
    {
        ArrayList<FoodItem>       menu     = new ArrayList<FoodItem>(); 
        ArrayList<RailwayStation> stations = new ArrayList<RailwayStation>();
        /*Type checking and store to database*/
        if( type == "FoodChain" )
        {
            FoodChain fs = new FoodChain(stations,name,certificate,menu,username,password,contact);
            ((FoodChain)fs).storeInDb();
            Agent     ag = new Agent(agentName,agentContact,agentUsername,agentPassword,username);
            ag.storeInDb();
        }
        else if( "Restaurant".equals(type) )
        {
            Restaurant fs = new Restaurant(stations,name,certificate,menu,username,password,contact);
            ((Restaurant)fs).storeInDb();
            Agent ag = new Agent(agentName,agentContact,agentUsername,agentPassword,username);
            ag.storeInDb();
        }
        else
        {
            throw new IllegalArgumentException("Invalid type");
        }
    }
    
    public static ArrayList<TrainRoute> getRoutes(ManagementAuth ma) throws AuthenticationException, UnableToConnectException, IllegalArgumentException
    {
        ArrayList<TrainRoute> routes= new ArrayList<>();
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getRoutesSave";
            
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
                
                /*Get routes*/
                res = conn.runQuery("SELECT * FROM  trainroute;");
                while(res.next())
                {
                    ArrayList<RailwayStation> stations = new ArrayList<>();
                    
                    /*Station reading*/
                    ArrayList<String> splitString = new ArrayList<String>(Arrays.asList(res.getString("Stations").split(",")));;
                    for(int i=0;i<splitString.size();i++)
                    {
                        if(!splitString.get(i).equals(""))
                        {
                            RailwayStation station = new RailwayStation(splitString.get(i));
                            stations.add(station);
                        }
                    }
                    
                    TrainRoute route = new TrainRoute(res.getString("Name"),stations,Integer.parseInt(res.getString("SuccessNumber")),Integer.parseInt(res.getString("TotalNumber")),res.getString("Sno"));
                    routes.add(route);
                }
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {   
                ex.printStackTrace();
                try 
                {
                    conn.runQuery("ROLLBACK TO "+save+";");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
        return routes;
    }
    
    
    public static void acceptRegistration(ManagementAuth ma,String foodSupplierUsername)throws IllegalArgumentException,UnableToConnectException, AuthenticationException
    {
        DbConnect conn = null;
        ResultSet res  = null;
            
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveThree;");
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
                
                /*Check if username is valid*/
                res = conn.runQuery("SELECT * FROM  foodsupplier WHERE Username= '"+foodSupplierUsername+"';");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Invalid Username");
                }
                
                /*Now change status*/
                conn.runUpdate("UPDATE foodsupplier SET Status = 'Accepted' WHERE Username = '"+foodSupplierUsername+"';");
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveThree;");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
    
    public static Statistics getStatistics(ManagementAuth ma,String identifier,String type) throws AuthenticationException, UnableToConnectException,IllegalArgumentException
    {
        DbConnect conn = null;
        ResultSet res  = null;
        Statistics st;
            
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveThree;");
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
                
                if(type == "Agent")
                {
                    /*Agent statistics*/
                    res = conn.runQuery("SELECT * FROM agent WHERE username = '"+identifier+"';");
                    if(!res.next())
                    {
                        throw new IllegalArgumentException("Invalid agent username");
                    }
                    else
                    {
                        st = new Statistics(Integer.parseInt(res.getString("SucessOrders")),Integer.parseInt(res.getString("TotalOrders")));
                    }
                }
                else if(type == "Route")
                {
                    /*Route statistics*/
                    res = conn.runQuery("SELECT * FROM route WHERE Sno= '"+identifier+"';");
                    if(!res.next())
                    {
                        throw new IllegalArgumentException("Invalid route Sno");
                    }
                    else
                    {
                        st = new Statistics(Integer.parseInt(res.getString("SucessNumber")),Integer.parseInt(res.getString("TotalNumber")));
                    }
                }
                else
                {
                    throw new IllegalArgumentException("Invalid type");
                }
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveThree;");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
        return st;
    }
    
    
    public static ArrayList<FoodSupplier> getRegistrants(ManagementAuth ma) throws AuthenticationException, UnableToConnectException,IllegalArgumentException
    {
        ArrayList<FoodSupplier> fs = new ArrayList<FoodSupplier>();
        DbConnect conn = null;
        ResultSet res  = null;
        
        try 
        {
            conn = new DbConnect("root","");
            conn.runQuery("SAVEPOINT saveSix;");
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
            
            /*Get list from db*/
            res = conn.runQuery("SELECT * FROM FoodSupplier WHERE Status='Unreviewed';");
            while(res.next())
            {
                if( res.getString("Type").equals("FoodChain") )
                {
                    ArrayList<RailwayStation> stations = new ArrayList<RailwayStation>();
                    ArrayList<FoodItem> menu = new ArrayList<FoodItem>();
                    ArrayList<String> splitString = new ArrayList<String>(Arrays.asList(res.getString("Menu").split(",")));
                    
                    /*Menu reading*/
                    for(int i=0;i<splitString.size();i++)
                    {
                        if(!splitString.get(i).equals(""))
                        {
                            FoodItem item = new FoodItem(Integer.parseInt(splitString.get(i)));
                            menu.add(item);
                        }
                    }
                    
                    /*Station reading*/
                    splitString = new ArrayList<String>(Arrays.asList(res.getString("Stations").split(",")));
                    
                    for(int i=0;i<splitString.size();i++)
                    {
                        if(!splitString.get(i).equals(""))
                        {   
                            JOptionPane.showMessageDialog(null,splitString.get(i));
                            RailwayStation station = new RailwayStation(Integer.parseInt(splitString.get(i)));
                            stations.add(station);
                        }
                    }
                    
                    FoodChain fc = new FoodChain(stations,res.getString("Name"),new Cert(res.getString("authCertPath")),menu,res.getString("Username"),res.getString("Password"),res.getString("Contact"));
                    fs.add(fc);
                }
                else if( res.getString("Type").equals("Restaurant") )
                {
                    ArrayList<RailwayStation> stations = new ArrayList<RailwayStation>();
                    ArrayList<FoodItem> menu = new ArrayList<FoodItem>();
                    ArrayList<String> splitString = new ArrayList<String>(Arrays.asList(res.getString("Menu").split(",")));
                    
                    /*Menu reading*/
                    for(int i=0;i<splitString.size();i++)
                    {
                        if(!splitString.get(i).equals(""))
                        {
                            FoodItem item = new FoodItem(Integer.parseInt(splitString.get(i)));
                            menu.add(item);
                        }
                    }
                    
                    /*Station reading*/
                    splitString = new ArrayList<String>(Arrays.asList(res.getString("Stations").split(",")));
                    
                    for(int i=0;i<splitString.size();i++)
                    {
                        if(!splitString.get(i).equals(""))
                        {
                            RailwayStation station = new RailwayStation(Integer.parseInt(splitString.get(i)));
                            stations.add(station);
                        }
                    }
                    
                    Restaurant fc = new Restaurant(stations,res.getString("Name"),new Cert(res.getString("authCertPath")),menu,res.getString("Username"),res.getString("Password"),res.getString("Contact"));
                    fs.add(fc);
                }
            }
        }
       catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveSix;");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
        
        
        return fs;
    }
    public static void AcceptOrder(int sno,AgentAuth fsas)throws IllegalArgumentException, AuthenticationException, UnableToConnectException
    {
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getStationsave";
            
            try 
                        {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT "+save+";");
                conn.runQuery("USE tghm");
                ArrayList<String> split;
                String fs="";
                
                /*Authenticate*/
                res = conn.runQuery("SELECT * FROM  agent WHERE Username= '"+fsas.getUsername()+"';");
                if(!res.next())
                {
                    throw new AuthenticationException("Invalid Username");
                }
                else if( !fsas.checkPassword( res.getString("Password") ) )
                {
                    throw new AuthenticationException("Username and password dont match");
                }
                fs = res.getString("FoodSupplierUsername");
                
                /*Check if sno exists*/
                res = conn.runQuery("SELECT * FROM  orderdetails WHERE Sno= '"+sno+"';");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Invalid sno");
                }
                else if(res.getString("Status").equals("Rejected"))
                {
                    throw new IllegalArgumentException("Cannot accept rejected order");
                }
                
                /*Accept*/
                conn.runUpdate("UPDATE orderdetails SET status ='Accepted' where Sno='"+sno+"';");
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO "+save+";");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
    public static void RejectOrder(int sno,AgentAuth fsas)throws IllegalArgumentException, AuthenticationException, UnableToConnectException
    {
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getStationsave";
            
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT "+save+";");
                conn.runQuery("USE tghm");
                ArrayList<String> split;
                String fs="";
                
                /*Authenticate*/
                res = conn.runQuery("SELECT * FROM  agent WHERE Username= '"+fsas.getUsername()+"';");
                if(!res.next())
                {
                    throw new AuthenticationException("Invalid Username");
                }
                else if( !fsas.checkPassword( res.getString("Password") ) )
                {
                    throw new AuthenticationException("Username and password dont match");
                }
                fs = res.getString("FoodSupplierUsername");
                
                /*Check if sno exists*/
                res = conn.runQuery("SELECT * FROM  orderdetails WHERE Sno= '"+sno+"';");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Invalid sno");
                }
                else if(res.getString("Status").equals("Accepted"))
                {
                    throw new IllegalArgumentException("Cannot reject accepted order");
                }
                
                /*Accept*/
                conn.runUpdate("UPDATE orderdetails SET status ='Rejected' where Sno='"+sno+"';");
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO "+save+";");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
    
    
    public static void rejectRegistration(ManagementAuth ma,String foodSupplierUsername)throws IllegalArgumentException,UnableToConnectException, AuthenticationException
    {
        DbConnect conn = null;
        ResultSet res  = null;
            
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveThree;");
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
                
                /*Check if username is valid*/
                res = conn.runQuery("SELECT * FROM  foodsupplier WHERE Username= '"+foodSupplierUsername+"';");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Invalid Username");
                }
                
                /*Now change status*/
                conn.runUpdate("UPDATE foodsupplier SET Status = 'Rejected' WHERE Username = '"+foodSupplierUsername+"';");
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveThree;");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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

    static void addRoute(ManagementAuth ma, String name, ArrayList<RailwayStation> stations) throws AuthenticationException, UnableToConnectException,IllegalArgumentException
    {
        DbConnect conn = null;
        ResultSet res  = null;
        String save = "getStationssave";
            
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
                
                /*Check if name is taken already*/
                res = conn.runQuery("SELECT Name FROM  trainroute WHERE Name= '"+name+"';");
                if(res.next())
                {
                    throw new IllegalArgumentException("Route name already exists");
                }
                  
                /*Add Route*/
                String stationsString= "";
                for(int i = 0;i<stations.size();i++)
                {
                    stationsString = stationsString+stations.get(i).getCode()+",";
                }
                conn.runUpdate("INSERT INTO trainroute (Name,SuccessNumber,TotalNumber,Stations) VALUES ('"+name+"','0','0','"+stationsString+"');");
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO "+save+";");
                } 
                catch (Exception ex1) 
                {
                    throw new UnableToConnectException("Unable to connect");
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
}
