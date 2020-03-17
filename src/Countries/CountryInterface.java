package Countries;

import DB.DBConnection;

import java.util.List;

public interface CountryInterface {

    DBConnection conn = DBConnection.getInstance();
    public List<Country> getAllCountries();
    public String getCountryByName(String name);
    public Country getCountryByCode(String code);
    public Country createCountry();

}
