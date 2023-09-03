package Computer;

import ListOfCities.ListOfCities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CitiesGenerator {
    protected static List<String> citiesForComputer = new ArrayList<>();

    public static List<String> getRandomCities(int difficulty) {
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

    private static void setDifficulty(int difficulty) {
        int numberOfRandomCity;
        switch (difficulty) {
            case 0:
                numberOfRandomCity = 100;
                break;
            case 1:
                numberOfRandomCity = 300;
                break;
            case 2:
                numberOfRandomCity = 500;
                break;
            case 3:
                numberOfRandomCity = 1000;
                break;
        }
    }
}

