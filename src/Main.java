import Countries.Country;
import Countries.CountryImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Main Method");
        CountryImpl country = new CountryImpl();
        List<Country> countryList = country.getAllCountries();
//            for (Country country1: countryList){
//            System.out.println(country1.getName());}
//        }
        String country1 = country.getCountryByName("Brazil");
        System.out.println("MEU PRINT"+country1);
    }
}



