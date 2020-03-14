import Countries.Country;
import Countries.CountryImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
        CountryImpl country = new CountryImpl();
        List<Country> countryList = country.getAllCountries();
        System.out.println(countryList);

        }
    }

