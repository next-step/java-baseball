import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseBall {
    private static final List<Integer> DEFAULT_RANGE = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final int DEFAULT_LENGTH = 3;

    private List<Integer> answer;

    public BaseBall() {
        this.answer = makeAnswer();
    }

    public BaseBall(List<Integer> answer) {
        this.answer = answer;
    }

    public static List<Integer> makeAnswer() {
        List<Integer> copy = new ArrayList<>(DEFAULT_RANGE);
        Collections.shuffle(copy);
        return copy.subList(0, DEFAULT_LENGTH);
    }
}
