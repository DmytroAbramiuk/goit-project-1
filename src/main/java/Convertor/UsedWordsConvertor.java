package Convertor;

import java.util.List;

public class UsedWordsConvertor {
    public static String convert(List<String> usedWords) {
        StringBuilder stringBuilder = new StringBuilder();

        if (usedWords == null) {
            return "none";
        }
        stringBuilder.append("<html>");

        for (String word : usedWords) {
            if (word.equals(usedWords.get(usedWords.size() - 1))) {
                stringBuilder.append(word)
                        .append("<html>");
                break;
            }

            stringBuilder.append(word)
                    .append("<br>");
        }

        return stringBuilder.toString();
    }
}
