package fr.sber.greenskills.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlantesDAO {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/user1";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args)
    {
        Connection conn = null;
        Statement st = null;
        try{
            //STEP 2: Register JDBC driver
            // Class.forName("org.postgresql.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","root","root");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            st = conn.createStatement();
            String sql;
            sql = "SELECT  first, last FROM Employees";
            ResultSet rs = st.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            //STEP 6: Clean-up environment
            rs.close();
            st.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        finally
        {
            //finally block used to close resources
            try{
                if(st!=null)
                    st.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }
}
