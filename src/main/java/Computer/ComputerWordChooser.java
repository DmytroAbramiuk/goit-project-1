package Computer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class ComputerWordChooser{

    public static String chooseCity(String playerCity, List<String> computerCities){
        List<String> correctCities;
        Random random = new Random();
        int randomIndex;

        if(playerCity.charAt(playerCity.length()-1)=='ь'){
            correctCities = computerCities.stream()
                    .filter(c->c.charAt(0)==playerCity.charAt(playerCity.length()-2))
                    .collect(Collectors.toList());
        }else {
            correctCities = computerCities.stream()
                    .filter(c -> c.charAt(0) == playerCity.charAt(playerCity.length() - 1))
                    .collect(Collectors.toList());
        }

        if(correctCities.isEmpty()){
            return null;
        }

        randomIndex = random.nextInt(correctCities.size());
        return correctCities.get(randomIndex);
    }
}
