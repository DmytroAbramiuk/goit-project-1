package Player;

import java.util.Collection;

public class WordValidator {
    public static boolean validate(Collection<String> allCities,Collection<String> usedWords ,
                                   String playerWord, String computerWord){
        computerWord = computerWord.toLowerCase();
        playerWord = playerWord.toLowerCase();
        System.out.println(allCities);
        if(computerWord.equals("firstword")){
            return true;
        }
        if(isWordInList(usedWords,playerWord)){
            return false;
        }

        if(playerWord.charAt(0) == computerWord.charAt(computerWord.length()-1)){
            if(isWordInList(allCities,playerWord)) {
                // Here we must add that word to used WordList
                //
                return true;
            }
        }
        return false;
    }
    private static boolean isWordInList(Collection<String> usedWords ,String playerWord){
        for (String usedWord:usedWords
             ) {
            if(usedWord.hashCode() == playerWord.hashCode()){
                if(usedWord.equals(playerWord)){
                    return true;
                }
            }
        }
        return false;
    }
}
