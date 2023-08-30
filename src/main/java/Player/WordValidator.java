package Player;

import java.util.Collection;

public class WordValidator {
    static boolean isPlayerWordFirst = true;
    // add File reader  here
    static Collection<String> allCities;
    static Collection<String> usedWords;
    static int wordCounter = 0;
    public static boolean validate(String playerWord, String computerWord){
        computerWord = computerWord.toLowerCase();
        playerWord = playerWord.toLowerCase();
        if(playerWord.equals("здаюсь")){
            // here we should add ending game method

        }
        if(isPlayerWordFirst){
            usedWords.add(playerWord);
            wordCounter++;
            isPlayerWordFirst = false;
            return true;
        }
        if(isWordInList(usedWords,playerWord)){
            return false;
        }
        if(isLetterMathing(playerWord,computerWord)){
            if(isWordInList(allCities,playerWord)) {
                usedWords.add(playerWord);
                wordCounter++;
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
    private static boolean isLetterMathing(String playerWord, String computerWord){
        return playerWord.charAt(0) == computerWord.charAt(computerWord.length()-1);
    }
}
