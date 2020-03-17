package Countries;

import Continents.Continent;
import DB.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryImpl implements CountryInterface {

    Connection conn = DBConnection.getInstance().getConnection();
    List<Country> myList = new ArrayList<>();

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
                Continent continent = Continent.valueOf(rs.getString("Continent").replace(" ", "_").toUpperCase());
                String code = rs.getString("Code");
                float area = rs.getFloat("SurfaceArea");
                String headOfState = rs.getString("HeadOfState");

                Country country = new Country(name, continent, code, area, headOfState);
                myList.add(country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myList;
    }


    @Override
    public String getCountryByName(String name) {
        return name;
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

