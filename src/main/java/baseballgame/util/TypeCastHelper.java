package baseballgame.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeCastHelper {

    public static List<String> stringToList(String input) {
        return new ArrayList<>(Arrays.asList(input.split("")));
    }
}
