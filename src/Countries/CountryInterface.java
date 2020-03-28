package Countries;

import DB.DBConnection;

import java.util.ArrayList;

public interface CountryInterface {

    DBConnection conn = DBConnection.getInstance();
    public ArrayList<Country.CountryBuilder> getAllCountries();
    public Country.CountryBuilder getCountryByName(String name);
    public Country getCountryByCode(String code);
    public boolean createCountry(Country country);

}
