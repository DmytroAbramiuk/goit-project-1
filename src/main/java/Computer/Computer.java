package Computer;

import ListOfCities.ListOfCities;

import java.util.List;

public class Computer {
    private final List<String> computerCities;
    private String currentCity;

    public Computer() {
        this.computerCities = CitiesGenerator.getRandomCities();
    }

    public String getNewCity(String playerCity){
        this.currentCity = ComputerWordChooser.chooseCity(playerCity, computerCities);

        if(currentCity!=null){
            computerCities.remove(currentCity);
            ListOfCities.usedCities.add(currentCity);
        }
        return currentCity;
    }

    public String getCurrentCity() {
        return currentCity;
    }
}
