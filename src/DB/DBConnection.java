package DB;

import java.sql.*;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://52.50.23.197:3306/world";
    private String username = "cctstudent";
    private String password = "Pass1234!";
    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static DBConnection getInstance() {
        System.out.println("here");
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}