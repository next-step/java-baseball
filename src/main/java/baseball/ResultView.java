package baseball;

public class ResultView {
    private static final String MESSAGE_STRIKE = "STRIKE";
    private static final String MESSAGE_BALL = "BALL";
    private static final String MESSAGE_NOTHING = "NOTHING";

    public static void printBallCountResult(BaseballResult baseballResult) {

        int strikeCount = baseballResult.getStrikeCount();
        int ballCount = baseballResult.getBallCount();

        StringBuilder sb = new StringBuilder();
        if (strikeCount > 0) {
            sb.append(strikeCount).append(MESSAGE_STRIKE);
        }
        if (ballCount > 0) {
            sb.append(ballCount).append(MESSAGE_BALL);
        }
        if (strikeCount == 0 && ballCount == 0) {
            sb.append(MESSAGE_NOTHING);
        }

        System.out.println(sb.toString());
    }
}