package Computer;

import ListOfCities.ListOfCities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CitiesGenerator {
    protected static List<String> citiesForComputer =new ArrayList<>();
    public static void getRandomCities() {
        int numberOfRandomCity = 2000;
        Random random = new Random();
        int listOfCitiesLenght = ListOfCities.allCities.size();
        while (citiesForComputer.size() < numberOfRandomCity) {
            String randomCity = ListOfCities.allCities.get(random.nextInt(listOfCitiesLenght));
            if (!citiesForComputer.contains(randomCity)) {
                citiesForComputer.add(randomCity.toLowerCase());
            }
        }
    }
}


