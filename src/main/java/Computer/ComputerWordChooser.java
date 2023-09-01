package Computer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class ComputerWordChooser {

    public static String chooseCity(String playerCity) {
        List<String> correctCities;
        Random random = new Random();
        int randomIndex;

        correctCities = Computer.computerCities.stream()
                .filter(c -> c.charAt(0) == playerCity.charAt(playerCity.length() - calculateDisplacement(playerCity)))
                .collect(Collectors.toList());


        if (correctCities.isEmpty()) {
            return null;
        }

        randomIndex = random.nextInt(correctCities.size());
        return correctCities.get(randomIndex);
    }

    public static int calculateDisplacement(String playerCity) {
        if (playerCity.charAt(playerCity.length() - 1) == 'ь') {
            return 2;
        } else {
            return 1;
        }
    }
}
