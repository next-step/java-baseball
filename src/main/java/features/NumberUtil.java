package features;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberUtil {
    public static List<Integer> generateAnswer() {
        List<Integer> answer = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(answer);
        return answer.subList(0, 3);
    }
}
