package game.baseball.number.utils;

import static game.baseball.number.exceptions.ExceptionCodes.SUPPRESS_INSTANCE;

import java.util.ArrayList;
import java.util.List;

public final class CollectionUtil {

    private CollectionUtil() {
        throw new AssertionError(SUPPRESS_INSTANCE);
    }

    public static List<Character> toList(char[] chars) {
        List<Character> characterList = new ArrayList<>();
        for (char aChar : chars) {
            characterList.add(aChar);
        }
        return characterList;
    }
}
