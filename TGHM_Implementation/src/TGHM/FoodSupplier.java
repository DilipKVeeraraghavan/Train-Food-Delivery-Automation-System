package TGHM;


import TGHM.Cert;
import TGHM.AgentAuth;
import TGHM.DbConnect;
import TGHM.UnableToConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.naming.AuthenticationException;

public class FoodSupplier {

	protected String Name;
	protected Cert authCert;
        protected FoodItem food;
	protected ArrayList<FoodItem> Menu = new ArrayList<FoodItem>();
        protected String username;
        protected String password;
        protected String contact;
        protected String type;
        
        public String getContact()
        {
            return contact;
        }
         
        public String getType()
        {
            return type;
        }
        
	public String getName() {
		return Name;
	}
        public FoodSupplier(){
            Name = "KFC";
            username ="KFC";
            authCert = new Cert();
            food =new FoodItem("Rice");
            Menu.add(food);
            food =new FoodItem();
            Menu.add(food);
            food =new FoodItem("Dal");
            Menu.add(food);
            food =new FoodItem("Paneer");
            Menu.add(food);
            contact ="123456";
            type = "FoodChain";
            authCert = new Cert();
        }
        public FoodSupplier(String name,Cert cert,ArrayList<FoodItem> menu,String user,String pass,String contactString,String Type)
        {
            Name     = name;
            authCert = cert;
            Menu     = menu;
            username = user;
            password = pass;
            contact  = contactString;
            type     = Type;
        }
        
        public FoodSupplier(String username) throws UnableToConnectException,IllegalArgumentException
        {
            DbConnect conn = null;
            ResultSet res  = null;
            
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveFour;");
                conn.runQuery("USE tghm");
                
                /*Check if username exists, if so read*/
                res = conn.runQuery("SELECT * FROM  foodsupplier WHERE Username= '"+username+";");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Invalid Username");
                }
                else
                {
                    Name     = res.getString("Name");
                    authCert = new Cert(res.getString("authCertPath"));
                    username = res.getString("Username");
                    password = res.getString("pass");
                    contact  = res.getString("contactString");
                    type     = res.getString("Type");
                    
                    /*Menu reading*/
                    ArrayList<String> splitString = new ArrayList<String>(Arrays.asList(res.getString("Menu").split(",")));
                    Menu = new ArrayList<FoodItem>();
                    for(int i=0;i<splitString.size();i++)
                    {
                        FoodItem item = new FoodItem(Integer.parseInt(splitString.get(i)));
                        Menu.add(item);
                    }
                }
                
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            }
            catch (ClassNotFoundException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveFour;");
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
                    conn.runQuery("ROLLBACK TO saveFour;");
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
                    conn.runQuery("ROLLBACK TO saveFour;");
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
                    conn.runQuery("ROLLBACK TO saveFour;");
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
        
        
        
        public void sendDetails(ArrayList<RailwayStation> stationList,AgentAuth AA,String foodSupplierUsername) throws UnableToConnectException, AuthenticationException, AlreadySetException
        {
            DbConnect conn = null;
            ResultSet res  = null;
            
            try 
            {
                int i,numberOfStations = stationList.size();
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveTwo;");
                conn.runQuery("USE tghm");
                String stations="";
                
                /*Authenticate*/
                res = conn.runQuery("SELECT * FROM agent WHERE Username= '"+AA.getUsername()+";");
                if(!res.next())
                {
                    throw new AuthenticationException("Invalid Username");
                }
                else if( !AA.checkPassword( res.getString("Password") ) )
                {
                    throw new AuthenticationException("Username and password dont match");
                }
                else if( !res.getString("Status").equals("Approved") )
                {
                    throw new AuthenticationException("Status is : "+res.getString("Status")+".Thus cannot set stations now.");
                }
                
                
                /*Check if all station exist in list and valid otherwise throw Invalid argument exception*/
                numberOfStations = stationList.size();
                if(numberOfStations == 0)
                {
                    throw new IllegalArgumentException("Station list can't be empty");
                }
                for( i = 0; i < numberOfStations; i++ )
                {
                    res = conn.runQuery("SELECT * FROM railwaystation WHERE Code = '"+stationList.get(i).getStationCode()+"';");
                    if( !res.next() )
                    {
                        throw new IllegalArgumentException("station : " + stationList.get(i).getStationName()+" is not in our list of stations");
                    }
                    else if( !( res.getString("Name").equals(stationList.get(i).getStationName())) )
                    {
                        throw new IllegalArgumentException("station : " + stationList.get(i).getStationName()+" does not match with it's station code");
                    }
                    else
                    {
                        stations = stations+stationList.get(i).getStationCode()+",";
                    }
                }
                
                /*Set list in table*/
                conn.runUpdate("UPDATE foodsupplier SET Stations='"+stations+"',NumberOfStations='"+stationList.size()+"' WHERE Username='"+foodSupplierUsername+"';");     
                
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
                    res.close();
                    conn.close();
                } 
                catch (SQLException ex) 
                {
                    
                }
            }
            
            
            
        }
        
	/**
	 * 
	 * @param Name
	 */
	public void setName(String Name) {
		// TODO - implement FoodSupplier.setName
		throw new UnsupportedOperationException();
	}

	public Cert getAuthCert() {
		return this.authCert;
	}

	/**
	 * 
	 * @param cert
	 */
	public void setAuthCert(Cert certificate) {
		// TODO - implement FoodSupplier.setAuthCert
		throw new UnsupportedOperationException();
	}

	public ArrayList<FoodItem> getFoodItems() {
		// TODO - implement FoodSupplier.getFoodItems
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param foodItems
	 */
	public void setFoodItems(FoodItem[] foodItems) {
		// TODO - implement FoodSupplier.setFoodItems
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param details
	 */
	public void setDetails(int details) {
		// TODO - implement FoodSupplier.setDetails
		throw new UnsupportedOperationException();
	}

    String getUsername() {
        return username;
    }

    

}