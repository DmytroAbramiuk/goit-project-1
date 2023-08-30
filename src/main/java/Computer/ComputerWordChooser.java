package Computer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ComputerWordChooser {
    public static String chooseWord(String playerWord){
        Random random = new Random();
        // Generated cities for Computer
        CitiesGenerator.getRandomCities();
        String finalPlayerWord = playerWord.toLowerCase();
        //Genereting List with correct first Letter
        List<String> correctCities = CitiesGenerator.citiesForComputer.stream()
                .filter(c -> c.charAt(0) == finalPlayerWord.charAt(finalPlayerWord.length()-1))
                .collect(Collectors.toList());
        if(correctCities.size() > 0){
            return correctCities.get(random.nextInt(correctCities.size()));
        }
        return "computerLose";
    }
}
