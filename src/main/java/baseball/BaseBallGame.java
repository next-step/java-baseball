package baseball;

public class BaseBallGame {
    private static int randomNumber = 0;

    private static InputOutput io = new InputOutput();
    private static Message message = new Message();
    private static RandomNumber random = new RandomNumber();
    private static Judgment judgment = new Judgment();

    private static final int restartGmae = 1;
    private static final int endGame = 2;

    public static void runGame() {
        io.println(message.START_GAME);
        io.println(message.ANSWER_CHECK);
        randomNumber = random.createNumber();
        while (!judgmentNumber());

        isEnd();
    }

    private static boolean isAnswer(int inputNumber) {
        if (randomNumber == inputNumber) {
            io.println(message.CHECK_END_GAME);
            return true;
        }

        return false;
    }

    private static boolean checkAnswer(int inputNumber) {
        if (inputNumber != 9) {
            return true;
        }
        io.println(String.valueOf(randomNumber));

        return false;
    }

    private static boolean judgmentNumber() {
        io.print(message.INPUT_NUMBER);
        int inputNumber = io.inputNumber();
        if (!checkAnswer(inputNumber)) {
            return false;
        }

        int[] randomNumberArray = judgment.separateNumber(randomNumber);
        int[] inputNumberArray = judgment.separateNumber(inputNumber);

        int[] hint = judgment.getHint(randomNumberArray, inputNumberArray);

        io.println(printlnHint(hint));

        return isAnswer(inputNumber);
    }

    private static String printlnHint(int[] hint) {
        if (judgment.isNothing(hint)) {
            return message.NOTHING;
        }

        if (hint[0] == 0) {
            return hint[1] + message.BALL;
        }

        if (hint[1] == 0) {
            return hint[0] + message.STRIKE;
        }

        return hint[0] + message.STRIKE + hint[1] + message.BALL;
    }

    private static void isEnd() {
        io.println(message.RESET_GAME);
        int inputNumber = Integer.parseInt(io.input());
        if (inputNumber == endGame) {
            io.println(message.END_GAME);
            return;
        }

        if (inputNumber == restartGmae) {
            runGame();
            return;
        }

        io.println(message.INPUT_NUMBER_INVALID_VALUE);
        isEnd();
    }
}
