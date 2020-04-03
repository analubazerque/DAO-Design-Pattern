/*
 *  @Author Ana Luiza Bazerque
 */

package View;

import Country.Continent;
import Country.Country;
import Country.CountryImplDAO;
import Country.CountryIntDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private String selection;
    private Scanner inputsc = new Scanner(System.in);
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private CountryIntDAO countryImpl = new CountryImplDAO();
    private ArrayList<Country> countryList;


    public void Menu() throws IOException {

        System.out.println("-------------------------\n");
        System.out.println("Please select an option from 1 to 5");
        System.out.println("1 - Search for a country by name");
        System.out.println("2 - Search for a country by code");
        System.out.println("3 - See all the countries in the list");
        System.out.println("4 - Add a country to the list");
        System.out.println("5 - Exit program");
        System.out.println("");

        // Checking if the input is valid in the menu

        boolean valid = false;
        while (!valid) {
            try {
                selection = input.readLine().trim();

                if (selection.matches("[1-5]")) {
                    valid = true;
                } else {
                    System.out.println("Not a valid option, please type in a number from 1 to 5:");
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        // parse the input into integer
        int inputSelection = Integer.parseInt(selection);

        // send the user to the correct function based on the option selected
        switch (inputSelection) {
            case 1:
                System.out.println("Please type in the country's name");
                String name = input.readLine();
                countryList = countryImpl.getCountriesByKeyword(name);
                printList(countryList);
                Menu();
                break;
            case 2:
                System.out.println("Please type in the country's code");
                String code  = input.readLine();
                System.out.println(countryImpl.getCountryByCode(code));
                Menu();
                break;
            case 3:
                countryList = countryImpl.getAllCountries();
                printList(countryList);
                Menu();
                break;
            case 4:
                createMenu();
                break;
            case 5:
                System.out.println("Thank you for accessing the Country database!");
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + selection);
        }
    }

    // user interaction to insert a country into the database

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

    // method that prints the list of countrys
    public void printList(ArrayList<Country> countryList) {
        for (int i = 0; i < countryList.size(); i++) {
            System.out.println(countryList.get(i));
        }

    }

}
