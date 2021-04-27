package utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    public static List<Character> convertStrToList(String str) {
        char[] chars = str.toCharArray();
        List<Character> charList = new ArrayList<>();
        for (char aChar : chars) {
            charList.add(aChar);
        }
        return charList;
    }
}
