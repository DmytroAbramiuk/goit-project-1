package Computer;

import ListOfCities.ListOfCities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CitiesGenerator {
    protected static List<String> citiesForComputer = new ArrayList<>();

    public static List<String> getRandomCities(int difficulty) {
        int numberOfRandomCity = setDifficulty(difficulty);
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

    private static int setDifficulty(int difficulty) {
        switch (difficulty) {
            case 0 -> {
                return 100;
            }
            case 1 -> {
                return 300;
            }
            case 2 -> {
                return 500;
            }
            case 3 -> {
                return 1000;
            }
        }
        return 0;
    }
}

