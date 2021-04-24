package baseball;

public class GameModel {
    private OutputProvider output = new OutputProvider();
    private NumberGenerator numberGenerator;
    private String expectNumber;
    private boolean isCompleted;
    private boolean isPending;

    public GameModel(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        initGame();
    }

    public String flushOutput() {
        return output.flushOutput();
    }

    public boolean isComplete() {
        return isCompleted;
    }

    public void input(String number) {
        if (isPending) {
            processPending(number);
            return;
        }
        processGame(number);
    }

    private void initGame() {
        expectNumber = numberGenerator.generate();
        isCompleted = false;
        isPending = false;
        output.appendRequestInput();
    }

    private void completeGame() {
        isCompleted = true;
    }

    private void processPending(String number) {
        if (number.equals("1")) {
            initGame();
        } else if (number.equals("2")) {
            completeGame();
        }
    }

    private void processGame(String number) {
        int strikeCount = calcStrikeCount(number);
        int ballCount = calcBallCount(number, strikeCount);
        makePlayResult(strikeCount, ballCount);
    }

    private void makePlayResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            output.appendNothing();
            return;
        }

        output.appendResultOutput(strikeCount, ballCount);
        output.appendRequestInput();
        checkComplete(strikeCount);
    }

    private int calcBallCount(String guess, int strikeCount) {
        char[] guesses = String.valueOf(guess).toCharArray();
        int count = 0;
        for (char c : guesses) {
            count += getOneIfContains(String.valueOf(c), expectNumber);
        }
        return count - strikeCount;
    }

    private int calcStrikeCount(String guess) {
        char[] guesses = String.valueOf(guess).toCharArray();
        char[] answer = expectNumber.toCharArray();
        int count = 0;
        for (int i = 0; i < guesses.length; i++) {
            count += getOneIfEqual(answer[i], guesses[i]);
        }
        return count;
    }

    private int getOneIfContains(CharSequence letter, String expect) {
        return expect.contains(letter) ? 1 : 0;
    }

    private <T> int getOneIfEqual(T left, T right) {
        return left == right ? 1 : 0;
    }

    private void checkComplete(int strikeCount) {
        if (strikeCount == 3) {
            isPending = true;
            output.appendComplete();
        }
    }
}


