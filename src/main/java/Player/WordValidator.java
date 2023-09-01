package Player;

import ListOfCities.ListOfCities;

public class WordValidator {

    public static boolean firstStepValidate(String playerCity) {
        return isCityExist(playerCity);
    }

    public static boolean validate(String playerCity, String computerCity) {
        return isFirstLetterFit(playerCity, computerCity) && isCityExist(playerCity) && isCityNotUsed(playerCity);
    }

    private static boolean isFirstLetterFit(String playerWord, String computerWord) {
        if (computerWord.charAt(computerWord.length() - 1) == 'ь') {
            return playerWord.charAt(0) == computerWord.charAt(computerWord.length() - 2);
        }
        return playerWord.charAt(0) == computerWord.charAt(computerWord.length() - 1);
    }

    private static boolean isCityExist(String playerCity) {
        return ListOfCities.allCities.contains(playerCity);
    }

    private static boolean isCityNotUsed(String playerCity) {
        return !(ListOfCities.usedCities.contains(playerCity));
    }
}
