package ListOfCities;

import FileReader.FileReader;

import java.io.File;
import java.util.List;

public class ListOfCities {
    public static List<String> allCities = FileReader.readFile(new File("src/main/java/Files/Cities.txt"));
}
