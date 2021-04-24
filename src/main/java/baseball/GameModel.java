package baseball;

public class GameModel {
    public final static String REQUEST_INPUT = "숫자를 입력해주세요 :";
    public final static String RESULT_NOTHING = "낫싱";
    public final static String RESULT_STRIKE = " 스트라이크";
    public final static String RESULT_BALL = " 볼";
    private StringBuffer output = new StringBuffer();
    private String expect;

    public GameModel(NumberGenerator numberGenerator) {
        this.expect = numberGenerator.generate();
        appendRequestInput();
    }

    public String flushOutput() {
        String output = this.output.toString();
        this.output.setLength(0);
        return output;
    }

    public boolean isComplete() {
        return false;
    }

    public void guess(String number) {
        int strikeCount = calcStrikeCount(number);
        int ballCount = calcBallCount(number, strikeCount);
        buildOutput(strikeCount, ballCount);
    }

    private void buildOutput(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            this.output.append(RESULT_NOTHING);
            return;
        }

        appendStrikeOutput(strikeCount);
        appendBallOutput(ballCount, strikeCount > 0);
        appendNewLineOutput();
        appendRequestInput();
    }

    private int calcBallCount(String guess, int strikeCount) {
        char[] guesses = String.valueOf(guess).toCharArray();
        int count = 0;
        for (char c : guesses) {
            count += getOneIfContains(String.valueOf(c), this.expect);
        }
        return count - strikeCount;
    }

    private int calcStrikeCount(String guess) {
        char[] guesses = String.valueOf(guess).toCharArray();
        char[] answer = this.expect.toCharArray();
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

    private void appendNewLineOutput() {
        this.output.append("\n");
    }

    private void appendRequestInput() {
        this.output.append(REQUEST_INPUT);
    }

    private void appendBallOutput(int ballCount, boolean hasStrike) {
        if (ballCount == 0) {
            return;
        }

        if (hasStrike) {
            this.output.append(" ");
        }

        this.output.append(ballCount + RESULT_BALL);
    }

    private void appendStrikeOutput(int strikeCount) {
        if (strikeCount == 0) {
            return;
        }

        this.output.append(strikeCount + RESULT_STRIKE);
    }
}


