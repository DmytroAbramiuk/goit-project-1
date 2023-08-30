package Computer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class CitiesGenerator {
    private Collection<String> citiesForComputer;

    public CitiesGenerator(Collection<String> citiesForComputer) {
        this.citiesForComputer = citiesForComputer;
    }

    public List<String> generateRandomCities() {
        List<String> randomCities = new ArrayList<>(citiesForComputer);
        List<String> selectedCities = new ArrayList<>();
        Random random = new Random();

        int numberOfCitiesToSelect = 200;

        while (selectedCities.size() < numberOfCitiesToSelect && !randomCities.isEmpty()) {
            int randomIndex = random.nextInt(randomCities.size());
            selectedCities.add(randomCities.remove(randomIndex));
        }

        return selectedCities;
    }

    public Collection<String> getCitiesForComputer() {
        return citiesForComputer;
    }
}


