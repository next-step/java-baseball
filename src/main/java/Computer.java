import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Computer {
    public static int nextTurn() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(numbers);

        int turn = 0;
        for (int i = 0; i < 3; ++i) {
            turn = turn * 10 + numbers.get(i);
        }

        return turn;
    }
}
