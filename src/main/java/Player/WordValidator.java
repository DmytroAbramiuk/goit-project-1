package Player;
import Computer.Computer;
import ListOfCities.ListOfCities;

public class WordValidator {

    public static boolean firstStepValidate(String playerCity){
        return isCityExist(playerCity);
    }
    public static boolean validate(String playerCity, String computerCity) {
        return isFirstLetterFit(playerCity, computerCity) && isCityExist(playerCity) && isCityNotUsed(playerCity);
    }

    private static boolean isFirstLetterFit(String playerWord, String computerWord){
        if(computerWord.charAt(computerWord.length()-1)=='ь'){
            return playerWord.charAt(0) == computerWord.charAt(computerWord.length()-2);
        }
        return playerWord.charAt(0) == computerWord.charAt(computerWord.length()-1);
    }

    private static boolean isCityExist(String playerCity){
        return ListOfCities.allCities.contains(playerCity);
    }

    private static boolean isCityNotUsed(String playerCity){
        boolean tralala = !(ListOfCities.usedCities.contains(playerCity));
        return !(ListOfCities.usedCities.contains(playerCity));
    }


//    public static boolean validate(String playerWord, String computerWord){
//        playerWord = playerWord.toLowerCase();
//        if(playerWord.equals("здаюсь")){
//            // here we should add ending game method
//
//        }
//        if(isPlayerWordFirst){
//            ListOfCities.usedWords.add(playerWord);
//            isPlayerWordFirst = false;
//            return true;
//        }
//        if(isWordInList(ListOfCities.usedWords,playerWord)){
//            return false;
//        }
//        if(isLetterMathing(playerWord,computerWord)){
//            if(isWordInList(ListOfCities.allCities,playerWord)) {
//                ListOfCities.usedWords.add(playerWord);
//                return true;
//            }
//        }
//        return false;
//    }
//    private static boolean isWordInList(List<String> usedWords ,String playerWord){
//        for (String usedWord:usedWords
//             ) {
//            if(usedWord.hashCode() == playerWord.hashCode()){
//                if(usedWord.equals(playerWord)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    private static boolean isLetterMathing(String playerWord, String computerWord){
//        return playerWord.charAt(0) == computerWord.charAt(computerWord.length()-1);
//    }
}
