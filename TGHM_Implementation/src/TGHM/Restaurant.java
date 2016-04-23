package TGHM;


import TGHM.FoodSupplier;
import TGHM.Cert;
import TGHM.DbConnect;
import TGHM.UnableToConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Restaurant extends FoodSupplier {

	private ArrayList<RailwayStation> restaurantStations;
	private int restaurantNumberOfStations;

	public ArrayList<RailwayStation> getRestaurantStations() {
		return this.restaurantStations;
	}
        public Restaurant(ArrayList<RailwayStation> stations,String name,Cert cert,ArrayList<FoodItem> menu,String user,String pass,String contact)
        {
            super(name,cert,menu,user,pass,contact,"Restaurant");
            restaurantStations = stations;
            restaurantNumberOfStations   = stations.size();
        }
	/**
	 * 
	 * @param restaurantStations
	 */
	public void setRestaurantStations(int restaurantStations) {
		// TODO - implement Restaurant.setRestaurantStations
		throw new UnsupportedOperationException();
	}

	public int getRestaurantNumberOfStations() {
		return this.restaurantNumberOfStations;
	}

	/**
	 * 
	 * @param restaurantNumberOfStations
	 */
	public void setRestaurantNumberOfStations(int restaurantNumberOfStations) {
		this.restaurantNumberOfStations = restaurantNumberOfStations;
	}
        
        public void storeInDb() throws UnableToConnectException,IllegalArgumentException
        {
            DbConnect conn = null;
            ResultSet res  = null;
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveOne;");
                conn.runQuery("USE tghm");
                String menu = "";
                String stations = "";

                /*Check if username exists already*/
                res = conn.runQuery("SELECT * FROM foodsupplier WHERE Username='"+username+"';");
                if(res.next())
                {
                    throw new IllegalArgumentException("Username Taken");
                }
                

                /*Now store the food supplier in db*/
                conn.runUpdate("INSERT INTO foodsupplier (authCertPath,Menu,Name,Stations,NumberOfStations,Type,Username,Password,Status,Contact) VALUES ('"+authCert.path+"','"+menu+"','"+Name+"','"+stations+"','0','Restaurant','"+username+"','"+password+"','Unreviewed','"+contact+"')");     
                
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
                    res.close();
                    conn.close();
                } 
                catch (SQLException ex) 
                {
                    
                }
            }
    }
        
}