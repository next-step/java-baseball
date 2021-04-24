import java.util.Arrays;

public class BaseBallGameController {
    private static final int BASEBALL_NUM_LENGTH = 3;

    public void start() {
        int[] opponentNumbers = createBaseBallNumber();

        // input numbers

        // cal Score

        // output Score
    }

    private static int[] createBaseBallNumber() {
        int[] baseBallNumbers = new int[BASEBALL_NUM_LENGTH];
        final int MIN_NUM = 1;
        final int MAX_NUM = 10;

        for (int i = 0; i < baseBallNumbers.length; i++) {
            baseBallNumbers[i] = (int) ((Math.random() * (MAX_NUM - MIN_NUM)) + MIN_NUM);
        }

        return baseBallNumbers;
    }
}
