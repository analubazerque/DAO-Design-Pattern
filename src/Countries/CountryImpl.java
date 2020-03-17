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

        Statement stmt = null;
        ResultSet rs = null;
        Country country = null;

        try {
            String query = "SELECT * FROM country WHERE Name = \"" + name + "\"";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                name = rs.getString("Name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public String getCountryByCode(String code) {
        Statement stmt = null;
        ResultSet rs = null;
        Country country = null;

        try {
            String query = "SELECT * FROM country WHERE Name = \"" + code + "\"";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                code = rs.getString("Code");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public void createCountry(Country country) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String query = "INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState)" +
                    " VALUES (JHG, Laos, Afrika, 1,4443, Joao Ninguem)";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
};

