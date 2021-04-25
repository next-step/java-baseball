package baseball.domain;

import baseball.domain.enums.ScoreStatus;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.BaseballNumbers.RANDOM_NUMBER_COUNT;
import static java.lang.String.format;

public class Score {
    private ScoreStatus scoreStatus;
    private int strike;
    private int ball;

    public static Score measureScore (BaseballNumbers answer, BaseballNumbers playerInput) {
        Score result = new Score();
        for (int i = 0 ; i < RANDOM_NUMBER_COUNT ; i++) {
            result.judgeBaseballNumber(answer, playerInput.getSpecificIndexValue(i), i);
        }
        result.changeScoreStatus();
        return result;
    }

    private void judgeBaseballNumber(BaseballNumbers answer, String partialPlayerInput, int playerInputIndex) {
        int judgementResult = answer.indexOf(partialPlayerInput);
        if (judgementResult == playerInputIndex) {
            plusStrikeCount();
        } else if (judgementResult > -1) {
            plusBallCount();
        }
    }

    private void plusStrikeCount() {
        this.strike++;
    }

    private void plusBallCount() {
        this.ball++;
    }

    private void changeScoreStatus() {
        if (strike == RANDOM_NUMBER_COUNT)
            scoreStatus = ScoreStatus.SUCCESS;
        else if (strike != RANDOM_NUMBER_COUNT) {
            scoreStatus = ScoreStatus.FAIL;
        }
    }

    public String getJudgeMessage() {
        String result = "";
        if (isPassed())
            result = format("%d개의 숫자를 모두 맞히셨습니다! 게임종료", RANDOM_NUMBER_COUNT);
        else if (strike == 0 && ball == 0)
            result = "낫싱";
        else if (strike >= 1 || ball >= 1)
            result = getStrikeBallMessage();

        return result;
    }

    private String getStrikeBallMessage() {
        List<String> result = new ArrayList<>();
        if (strike >= 1 && strike < RANDOM_NUMBER_COUNT)
            result.add(format("%d 스트라이크", strike));

        if (ball >= 1)
            result.add(format("%d 볼", ball));

        return String.join(" ", result);
    }

    public ScoreStatus getScoreStatus() {
        return scoreStatus;
    }

    public boolean isPassed() {
        boolean result = false;
        if(scoreStatus == ScoreStatus.SUCCESS) {
            result = true;
        }
        return result;
    }

    public static Score createErrorStateScore() {
        Score score = new Score();
        score.scoreStatus = ScoreStatus.ERROR;
        return score;
    }
}
