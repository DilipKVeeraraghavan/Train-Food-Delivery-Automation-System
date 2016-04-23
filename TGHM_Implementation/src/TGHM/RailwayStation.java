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

/**
 *
 * @author DILIPKUMAR
 */
public class RailwayStation {

	private String stationName;
	private String stationCode;

        public RailwayStation(){
            stationName = "Kharagpur";
            stationCode = "721302";
        }
        
        public RailwayStation(String name,String code)
        {
            stationName = name;
            stationCode = code;
        }
         public String getName()
            {
                return stationName;
            }
         public String getCode()
         {
             return stationCode;
         }
        public RailwayStation(int Sno) throws UnableToConnectException 
        {
            DbConnect conn = null;
            ResultSet res  = null;
           
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveSeven;");
                conn.runQuery("USE tghm");
                
                /*Check if valid int, if so read*/
                res = conn.runQuery("SELECT * FROM  railwaystation WHERE Sno= '"+Sno+"';");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Invalid Sno,cant read");
                }
                else
                {
                    stationName = res.getString("Name");
                    stationCode = res.getString("Code");
                }
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            }
            catch (ClassNotFoundException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveSeven;");
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
                    conn.runQuery("ROLLBACK TO saveSeven;");
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
                    conn.runQuery("ROLLBACK TO saveSeven;");
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
                    conn.runQuery("ROLLBACK TO saveSeven;");
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
    public RailwayStation(String code) throws UnableToConnectException 
        {
            DbConnect conn = null;
            ResultSet res  = null;
           
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveSeven;");
                conn.runQuery("USE tghm");
                
                /*Check if valid int, if so read*/
                res = conn.runQuery("SELECT * FROM  railwaystation WHERE Code= '"+code+"';");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Invalid Code,cant read");
                }
                else
                {
                    stationName = res.getString("Name");
                    stationCode = res.getString("Code");
                }
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            }
            catch (ClassNotFoundException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveSeven;");
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
                    conn.runQuery("ROLLBACK TO saveSeven;");
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
                    conn.runQuery("ROLLBACK TO saveSeven;");
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
                    conn.runQuery("ROLLBACK TO saveSeven;");
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
    RailwayStation(int code, ManagementAuth ma) throws AuthenticationException, UnableToConnectException 
    {
        DbConnect conn = null;
            ResultSet res  = null;
            String save = "RailwayStationSave";            
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
                
                
                /*Get station*/
                res = conn.runQuery("SELECT * FROM railwaystation WHERE  code='"+code+"';");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Invalid code");
                }
                else
                {
                    stationName = res.getString("Name");
                    stationCode = res.getString("Code");
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
        
	public String getStationName() {
		return this.stationName;
	}
        
        public void setStationName(int stationName) {
		// TODO - implement RailwayStation.setStationName
		throw new UnsupportedOperationException();
	}

	public String getStationCode() {
		return this.stationCode;
	}
           
	/**
	 * 
	 * @param attribute
	 */
	public void setStationCode(int attribute) {
		// TODO - implement RailwayStation.setStationCode
		throw new UnsupportedOperationException();
	}

}