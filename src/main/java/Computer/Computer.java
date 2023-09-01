package Computer;

import ListOfCities.ListOfCities;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    protected static List<String> computerCities;
    private String currentCity;
    private List<String> usedComputerCities;

    public Computer() {
        computerCities = CitiesGenerator.getRandomCities();
    }

    public String getNewCity(String playerCity) {
        this.currentCity = ComputerWordChooser.chooseCity(playerCity);

        if (currentCity != null) {
            computerCities.remove(currentCity);
            ListOfCities.usedCities.add(currentCity);
        }
        return currentCity;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void saveComputerCity(String computerCity){
        if(usedComputerCities==null)
            usedComputerCities = new ArrayList<>();

        usedComputerCities.add(computerCity);
    }

    public List<String> getUsedComputerCities() {
        return usedComputerCities;
    }
}
