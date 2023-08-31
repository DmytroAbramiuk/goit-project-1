package Computer;

import ListOfCities.ListOfCities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CitiesGenerator {
    protected static List<String> citiesForComputer =new ArrayList<>();
    public static List<String> getRandomCities() {
        int numberOfRandomCity = 200;
        Random random = new Random();
        int listOfCitiesLength = ListOfCities.allCities.size();
        while (citiesForComputer.size() < numberOfRandomCity) {
            String randomCity = ListOfCities.allCities.get(random.nextInt(listOfCitiesLength));
            if (!citiesForComputer.contains(randomCity)) {
                citiesForComputer.add(randomCity.toLowerCase());
            }
        }

        return citiesForComputer;
    }
}


