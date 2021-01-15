package features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberUtil {
    public static List<Integer> generateAnswer() {
        List<Integer> answer = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(answer);
        return answer.subList(0, 3);
    }

    public static List<Integer> convertString(String userInput) {
        List<Integer> converted = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            converted.add(Character.getNumericValue(userInput.charAt(i)));
        }
        return converted;
    }
}
