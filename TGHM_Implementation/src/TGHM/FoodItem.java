
package TGHM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodItem {
        private String Name;
	private int Price;

        public FoodItem(){
            Name = "Roti";
            Price = 5;
        }

        public FoodItem(String name){
            Name = name;
            Price = 10;
        }
        
        @Override
        public boolean equals(Object o){
            if (o == this) {
            return true;
        }
 
        
        if (!(o instanceof FoodItem)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members 
        FoodItem c = (FoodItem) o;
         
        // Compare the data members and return accordingly 
        return (Name.equals(c.getName()))
                && (Price == c.getPrice());
        }
        
        
        public String getName() {
            return Name;
	}

	public void setName(String Name) {
		// TODO - implement FoodItem.setName
		throw new UnsupportedOperationException();
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int Price) {
		// TODO - implement FoodItem.setPrice
		throw new UnsupportedOperationException();
	}
        
         public FoodItem(String name,int price)
        {
            Name  = name;
            Price = price;
        }
        
        FoodItem(int Sno) throws UnableToConnectException 
        {
            DbConnect conn = null;
            ResultSet res  = null;
            
            try 
            {
                conn = new DbConnect("root","");
                conn.runQuery("SAVEPOINT saveFive;");
                conn.runQuery("USE tghm");
                
                /*Check if valid int, if so read*/
                res = conn.runQuery("SELECT * FROM  fooditem WHERE Sno= '"+Sno+"';");
                if(!res.next())
                {
                    throw new IllegalArgumentException("Invalid Sno,cant read");
                }
                else
                {
                    Name  = res.getString("Name");
                    Price = Integer.parseInt(res.getString("Price"));
                }
                
                /*Commit*/
                conn.runQuery("COMMIT;");
            }
            catch (ClassNotFoundException ex) 
            {
                try 
                {
                    conn.runQuery("ROLLBACK TO saveFive;");
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
                    conn.runQuery("ROLLBACK TO saveFive;");
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
                    conn.runQuery("ROLLBACK TO saveFive;");
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
                    conn.runQuery("ROLLBACK TO saveFive;");
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
        
}