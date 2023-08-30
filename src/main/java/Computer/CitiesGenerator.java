package Computer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class CitiesGenerator {
    public static List<String> getRandomCities(List<String> allCities) {
        int numberOfRandomCity = 20;
        List<String> citiesForComputer = new ArrayList<>();
        Random random = new Random();

        while(citiesForComputer.size()<numberOfRandomCity){
            String randomCity = allCities.get(random.nextInt(allCities.size()));
            if (!citiesForComputer.contains(randomCity)) {
                citiesForComputer.add(randomCity);
            }

        }

        return citiesForComputer;
    }
}


