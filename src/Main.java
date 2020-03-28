import Countries.Continent;
import Countries.Country;
import Countries.CountryImpl;
import Countries.CountryInterface;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Main Method");
        CountryInterface country = new CountryImpl();
        ArrayList<Country.CountryBuilder> countryList = country.getAllCountries();
     System.out.println(countryList);
//
//        Country myCountry = new Country("Ursal", Continent.SOUTH_AMERICA, "URS", 200000, "The People");
//        System.out.println(myCountry);
//
//        Country country1 = country.getCountryByName("Ursal");
//        System.out.println(country1);
        //country.createCountry(country1);

        Country country2 = country.getCountryByCode("URS");
        System.out.println(country2);

    }
}



