package FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> readFile(File file) {
        List<String> fileContent = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                fileContent.add(String.valueOf(scanner.nextLine()).toLowerCase());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return fileContent;

    }
}
