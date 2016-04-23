package TGHM;


import java.sql.*;

public class DbConnect {
    
    private String url = "jdbc:mysql://localhost:3306/";
    private Connection con;
    private Statement stt;
                        
    public DbConnect(String username,String pass) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con      = DriverManager.getConnection(url, username, pass);
        con.setAutoCommit(false);
        stt      = con.createStatement();
    }
    
    public ResultSet runQuery(String query) throws SQLException
    {   
        return  stt.executeQuery(query);
    }
    
    public int runUpdate(String query) throws SQLException
    {
        return  stt.executeUpdate(query);
    }
    
    /**
     *
     * @throws SQLException
     */
    public void close() throws SQLException
    {
        stt.close();
        con.close();
    }
}
