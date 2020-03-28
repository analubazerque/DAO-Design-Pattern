package View;

import Country.Continent;
import Country.Country;
import Country.CountryImpl;
import Country.CountryInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private int selection;
    private Scanner inputsc = new Scanner(System.in);
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private CountryInterface countryImpl = new CountryImpl();
    private ArrayList<Country> countryList;


    public void Menu() throws IOException {

        countryList = countryImpl.getAllCountries();

        System.out.println("-------------------------\n");
        System.out.println("Please select an option from 1 to 5");
        System.out.println("1 - Search for a country by name");
        System.out.println("2 - Search for a country by code");
        System.out.println("3 - See all the countries in the list");
        System.out.println("4 - Add a country to the list");
        System.out.println("5 - Exit program");
        System.out.println("");
        selection = inputsc.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Please type in the country's name");
                String name = input.readLine();
                System.out.println(countryImpl.getCountryByName(name));
                Menu();
                break;
            case 2:
                System.out.println("Please type in the country's code");
                String code  = input.readLine();
                System.out.println(countryImpl.getCountryByCode(code));
                Menu();
                break;
            case 3:
                System.out.println(countryList);
                Menu();
                break;
            case 4:
                createMenu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + selection);
        }
    }

    private void createMenu() throws IOException {

        System.out.println("");
        System.out.println("Please type in the Country's Code (The first 3 letter of the word or of each word in the name)");
        String code = input.readLine();
        System.out.println("Please type in the Country's Name");
        String name = input.readLine();
        System.out.println("Please type in the Continent");
        String continentStr = input.readLine();
        Continent continent = Continent.getContinentEnum(continentStr);
        System.out.println("Please type in the Surface Area of the country");
        float area = inputsc.nextFloat();
        System.out.println("Please type in the Head of State");
        String headOfState = input.readLine();

        Country.CountryBuilder country = new Country.CountryBuilder(code, name, continent, area, headOfState);
        country.build();
        countryImpl.createCountry(country.build());

    }

}