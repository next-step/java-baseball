package baseball.view;

import baseball.dto.Response;

import java.util.StringJoiner;

public class ResultView {
    private static final String END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE = "%d 스트라이크";
    private static final String BALL = "%d볼";
    private static final String NOTING = "낫싱";

    public static void print(final Response response) {
        if (response.isFinish()) {
            System.out.println(END);
            return;
        }

        StringJoiner stringJoiner = new StringJoiner(" ");
        int strikeCount = response.getStrikeCount();
        int ballCount = response.getBallCount();

        if (ballCount == 0 & ballCount == 0) {
            System.out.println(NOTING);
            return;
        }

        if (strikeCount > 0) {
            stringJoiner.add(String.format(STRIKE, strikeCount));
        }

        if (ballCount > 0) {
            stringJoiner.add(String.format(BALL, ballCount));
        }

        System.out.println(stringJoiner.toString());
    }
}
