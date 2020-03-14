package Countries;

import DB.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CountryImpl implements CountryInterface {

    Connection conn = DBConnection.getInstance().getConnection();

    public CountryImpl() {}

    @Override
    public List<Country> getAllCountries() {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM country";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("Name");
                String continent = rs.getString("Continent");
                String code = rs.getString("Code");
                String area = rs.getString("SurfaceArea");
                String headOfState = rs.getString("HeadOfState");
                System.out.println(rs);

            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Country getCountryByName(String name) {
        return null;
    }

    @Override
    public Country getCountryByCode(String code) {
        return null;
    }

    @Override
    public Country createCountry() {
        return null;
    }

    //Country countries = Country.(rs.getString("name"), rs.getString("continent"), rs.getString("code"), rs.getInt("area"), rs.getString("headOfState"));


};

