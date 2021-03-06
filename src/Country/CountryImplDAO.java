/*
 *  @Author Ana Luiza Bazerque
 */

package Country;
import DB.DBConnection;
import java.sql.*;
import java.util.ArrayList;

/* Implementation of the methods created in the interface
* using the DAO Design Pattern */

public class CountryImplDAO implements CountryIntDAO {

    DBConnection db = DBConnection.getInstance();
    ArrayList<Country> countriesList = new ArrayList<Country>();
    String query = "SELECT * FROM country";
    ResultSet rs;
    Continent continent;
    String code = "";
    float area = 0;
    String headOfState = "";
    Country.CountryBuilder countryBuilder;

    public CountryImplDAO() {
    }

    // method to get all the countries from the db and save them into an arrayList
    @Override
    public ArrayList<Country> getAllCountries() {
        String query = "SELECT * FROM country";
        rs = db.select(query);
        try {

            while (rs.next()) {
                String name = rs.getString("Name");
                String cntntSt = rs.getString("Continent");
                Continent continent1 = Continent.getContinentEnum(cntntSt);
                code = rs.getString("Code");
                area = rs.getFloat("SurfaceArea");
                headOfState = rs.getString("HeadOfState");

                countryBuilder = new Country.CountryBuilder(code, name, continent1, area, headOfState);
                countriesList.add(countryBuilder.build());

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countriesList;
    }

    // method that finds a country from its keyword
    @Override
    public ArrayList<Country> getCountriesByKeyword(String name) {

        String query = "SELECT * FROM country WHERE Name LIKE \"%" + name + "%\"";
        ResultSet rs = db.select(query);

        try {

            while (rs.next()) {
                name = rs.getString("Name");
                String cntntSt = rs.getString("Continent");
                Continent continent = Continent.getContinentEnum(cntntSt);
                code = rs.getString("Code");
                area = rs.getFloat("SurfaceArea");
                headOfState = rs.getString("HeadOfState");
                countryBuilder = new Country.CountryBuilder(code, name, continent, area, headOfState);
                countriesList.add(countryBuilder.build());

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countriesList;
    }

    // method that finds a country from its code
    @Override
    public Country getCountryByCode(String code) {

        String query = "SELECT * FROM country WHERE Code = \"" + code + "\"";
        ResultSet rs = db.select(query);
        try {

            while (rs.next()) {
                String name = rs.getString("Name");
                System.out.println(name);
                String cntntSt = rs.getString("Continent");
                Continent continent = Continent.getContinentEnum(cntntSt);
                code = rs.getString("Code");
                float area = rs.getFloat("SurfaceArea");
                String headOfState = rs.getString("HeadOfState");

                countryBuilder = new Country.CountryBuilder(code, name, continent, area, headOfState);
                return countryBuilder.build();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // method to create a country object to be sent to the db
    @Override
    public boolean createCountry(Country inputCountry) {

        String code = inputCountry.getCode();
        String name = inputCountry.getName();
        Continent continent = inputCountry.getContinent();
        float area = inputCountry.getArea();
        String headOfState = inputCountry.getHeadOfState();
        String query = "INSERT INTO world.country (Code, Name, Continent, SurfaceArea, HeadOfState)" +
                "VALUES (\"" + code + "\", \"" + name + "\", \"" + continent + "\", " + area + ", \"" + headOfState + "\")";

        return db.insert(query);

        }

};