package TGHM;


import TGHM.DbConnect;
import TGHM.UnableToConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Agent 
{

	private String Name;
	private String agentFoodSupplier;
	private int agentNumberOfOrdersAccepted;
	private int agentNumberOfSuccesfullOrders;
	private String ContactDetails;
        private String username;
        private String password;

        public Agent(String agentName, String agentContact, String agentUsername, String agentPassword, String supplierUsername) 
        {
            Name                          = agentName;
            ContactDetails                = agentContact;
            username                      = agentUsername;
            password                      = agentPassword;
            agentFoodSupplier             = supplierUsername;
            agentNumberOfOrdersAccepted   = 0;
            agentNumberOfSuccesfullOrders = 0;
        }
        
        public void storeInDb() throws UnableToConnectException
        {
            DbConnect conn = null;
            ResultSet res  = null;
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveOne;");
                conn.runQuery("USE tghm");

                /*Now store the agent in db*/
                conn.runUpdate("INSERT INTO agent (Name,SucessOrders,TotalOrders,FoodSupplierUsername,Contact,Username,Password) VALUES ('"+Name+"','"+agentNumberOfSuccesfullOrders+"','"+agentNumberOfOrdersAccepted+"','"+agentFoodSupplier+"','"+ContactDetails+"','"+username+"','"+password+"');");     
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveOne;");
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
                    conn.runQuery("ROLLBACK TO saveOne;");
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
                    conn.runQuery("ROLLBACK TO saveOne;");
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
                    conn.runQuery("ROLLBACK TO saveOne;");
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
                catch (Exception ex) 
                {
                    
                }
            }
        }
        public String getContact()
        {
            return ContactDetails;
        }

	public String getName() {
		return Name;
	}

	/**
	 * 
	 * @param Name
	 */
	
	public String getAgentFoodSupplier() 
        {
		return agentFoodSupplier;
	}

	

	public int getTotalDeliveries() 
        {
		return agentNumberOfOrdersAccepted;
	}

	/**
	 * 
	 * @param agentNumberOfOrdersAccepted
	 */
	public void setAgentNumberOfOrdersAccepted(int agentNumberOfOrdersAccepted) {
		this.agentNumberOfOrdersAccepted = agentNumberOfOrdersAccepted;
	}

	public int getSuccesfullDeliveries() 
        {
		return agentNumberOfSuccesfullOrders;
	}

	/**
	 * 
	 * @param agentNumberOfSuccesfulOrders
	 */
	
        
}