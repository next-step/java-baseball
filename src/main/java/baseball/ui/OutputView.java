package baseball.ui;

public class OutputView {
    public void printResult(GameResultResponse result) {
        System.out.println(format(result));
    }

    private String format(GameResultResponse result) {
        if (result.isNothing()) {
            return "낫싱";
        }
        if (result.isEnd()) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        return formatStrikeAndBall(result.getStrike(), result.getBall());
    }

    private String formatStrikeAndBall(int strike, int ball) {
        StringBuilder stringBuilder = new StringBuilder();
        if (strike != 0) {
            stringBuilder.append(String.format("%d 스트라이크 ", strike));
        }
        if (ball != 0) {
            stringBuilder.append(String.format("%d 볼", ball));
        }
        return stringBuilder.toString();
    }
}
