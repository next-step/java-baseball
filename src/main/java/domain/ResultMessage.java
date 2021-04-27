package domain;

public class ResultMessage {
    private static final String STRIKE = " 스트라이크 ";
    private static final String BALL = " 볼 ";
    private static final String NOTHING = "낫싱";
    private static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printResult(int strikeCount, int ballCount) {
        String resultMessage = "";

        if(strikeCount != 0 ) {
            resultMessage += strikeCount + STRIKE;
        }
        if(ballCount != 0) {
            resultMessage += ballCount + BALL;
        }

        if(resultMessage.equals("")) {
            resultMessage += NOTHING;
        }
        System.out.println(resultMessage);
    }

    public static void printWinningMessage() {
        System.out.println(WINNING_MESSAGE);
    }
}
