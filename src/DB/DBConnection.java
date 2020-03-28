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

    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet select(String query) {

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public boolean insert(String query) {
        try {
            stmt.executeQuery(query);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }

        public static DBConnection getInstance() {
        System.out.println("getting db instance here");
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}