package Countries;

import DB.DBConnection;

import java.util.List;

public interface CountryInterface {

    DBConnection conn = DBConnection.getInstance();
    public List<Country> getAllCountries();
    public String getCountryByName(String name);
    public String getCountryByCode(String code);
    public void createCountry(Country country);

}
