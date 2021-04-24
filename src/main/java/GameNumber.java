import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameNumber {
    public static final int FROM_INDEX = 0;
    public static final int TO_INDEX = 3;
    private ArrayList<Integer> gameNumber;
    private static final Integer[] sourceNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static List<Integer> randomGenerate() {
        List<Integer> sourceNumberList = Arrays.asList(sourceNumbers);
        Collections.shuffle(sourceNumberList);
        return sourceNumberList.subList(FROM_INDEX, TO_INDEX);
    }
}
