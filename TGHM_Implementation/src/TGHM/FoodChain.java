package TGHM;


import TGHM.DbConnect;
import TGHM.UnableToConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FoodChain extends FoodSupplier {

	private ArrayList<RailwayStation> restaurantStations;
	private int foodChainNumberOfStations;

	public ArrayList<RailwayStation> getRestaurantStations() {
		return this.restaurantStations;
	}

	/**
	 * 
	 * @param restaurantStations
	 */
        public FoodChain(ArrayList<RailwayStation> stations,String name,Cert cert,ArrayList<FoodItem> menu,String user,String pass,String contact)
        {
            super(name,cert,menu,user,pass,contact,"FoodChain");
            restaurantStations = stations;
            foodChainNumberOfStations   = stations.size();
        }
        
        
        
	public void setRestaurantNumberOfStations() {
		// TODO - implement FoodChains.setRestaurantNumberOfStations
		throw new UnsupportedOperationException();
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
                conn.runUpdate("INSERT INTO foodsupplier (authCertPath,Menu,Name,Stations,NumberOfStations,Type,Username,Password,Status,Contact) VALUES ('"+authCert.path+"','"+menu+"','"+Name+"','"+stations+"','0','FoodChain','"+username+"','"+password+"','Unreviewed','"+contact+"')");     
                
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveOne;");
                } 
                catch (SQLException ex1) 
                {
                    
                }
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "in");
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