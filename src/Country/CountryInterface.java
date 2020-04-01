/*
 *  @Author Ana Luiza Bazerque
 */

package Country;

import DB.DBConnection;

import java.util.ArrayList;

public interface CountryInterface {

    // interface that is part of the DAO implementation

    DBConnection conn = DBConnection.getInstance();
    public ArrayList<Country> getAllCountries();
    public Country getCountryByName(String name);
    public Country getCountryByCode(String code);
    public boolean createCountry(Country country);

}
