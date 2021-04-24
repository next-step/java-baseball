package baseball;

public class GameModel {
    public final static String REQUEST_INPUT = "숫자를 입력해주세요 :";
    public final static String RESULT_NOTHING = "낫싱";
    public final static String RESULT_STRIKE = " 스트라이크";
    public final static String RESULT_BALL = " 볼";
    public final static String RESULT_COMPLETE = "3개의 숫자를 모두 맞히셨습니다!\n게임 종료게임을 새로시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private OutputProvider output = new OutputProvider();
    private String expectNumber;
    private boolean isCompleted;
    private boolean isPending;

    public GameModel(NumberGenerator numberGenerator) {
        this.expectNumber = numberGenerator.generate();
        this.isCompleted = false;
        this.isPending = false;
        output.appendRequestInput();
    }

    public String flushOutput() {
        return output.flushOutput();
    }

    public boolean isComplete() {
        return this.isCompleted;
    }

    public void input(String number) {
        if (this.isPending) {
            processPending(number);
            return;
        }
        processGame(number);
    }

    private void processPending(String number) {
        if (number.equals("1")) {
            this.isPending = false;
            output.appendRequestInput();

        } else if (number.equals("2")) {
            this.isCompleted = true;
        }
    }

    private void processGame(String number) {
        int strikeCount = calcStrikeCount(number);
        int ballCount = calcBallCount(number, strikeCount);
        buildOutput(strikeCount, ballCount);
    }

    private void buildOutput(int strikeCount, int ballCount) {
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
            count += getOneIfContains(String.valueOf(c), this.expectNumber);
        }
        return count - strikeCount;
    }

    private int calcStrikeCount(String guess) {
        char[] guesses = String.valueOf(guess).toCharArray();
        char[] answer = this.expectNumber.toCharArray();
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
            this.isPending = true;
            this.output.appendComplete();
        }
    }
}


