
/*
 *  @Author Ana Luiza Bazerque
 */

package DB;

import java.sql.*;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://52.50.23.197:3306/world";
    private String username = "cctstudent";
    private String password = "Pass1234!";
    private ResultSet rs = null;
    private Statement stmt = null;

    /* the Database class was implemented using the Singleton Pattern
    * */

    private DBConnection() {
        try {
            // loading db driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // get connection with db
            connection = DriverManager.getConnection(
                    url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // method to get data from the database
    public ResultSet select(String query) {

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // method for inserting a country into the database
    public boolean insert(String query) {
        try {
            stmt.execute(query);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }
        // static method to control the access to the db
        public static DBConnection getInstance() {

        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}