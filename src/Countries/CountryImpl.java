package Countries;
import DB.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class CountryImpl implements CountryInterface {

    DBConnection db = DBConnection.getInstance();
    ArrayList<Country.CountryBuilder> countriesList = new ArrayList<Country.CountryBuilder>();
    String query = "SELECT * FROM country";
    ResultSet rs;

    Continent continent;
    String code = "";
    float area = 0;
    String headOfState = "";
    Country.CountryBuilder countryBuilder;

    public CountryImpl() {
    }

    @Override
    public ArrayList<Country.CountryBuilder> getAllCountries() {
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

                countryBuilder = new Country.CountryBuilder(name, continent1, code, area, headOfState);
                countriesList.add(countryBuilder);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countriesList;
    }


    @Override
    public Country.CountryBuilder getCountryByName(String name) {

        String query = "SELECT * FROM country WHERE Name = \"" + name + "\"";
        //Statement stmt = null;
        ResultSet rs = db.select(query);

        try {

            while (rs.next()) {
                name = rs.getString("Name");
                String cntntSt = rs.getString("Continent");
                Continent continent = Continent.getContinentEnum(cntntSt);
                code = rs.getString("Code");
                area = rs.getFloat("SurfaceArea");
                headOfState = rs.getString("HeadOfState");
                countryBuilder = new Country.CountryBuilder(name, continent, code, area, headOfState);
                return countryBuilder;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

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

                countryBuilder = new Country.CountryBuilder(name, continent, code, area, headOfState);
                return countryBuilder;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean createCountry(Country country) {

        String name = country.getName();
        Continent continent = country.getContinent(name);
        float area = country.getArea();
        String headOfState = country.getHeadOfState();
        String query = "INSERT INTO world.country (Code, Name, Continent, SurfaceArea, HeadOfState)\n" +
                "VALUES ('URS', 'Ursal', 'South America', '20000000', 'The People')";

        return db.insert(query);

        }
    };

