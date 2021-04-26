package player;

import java.util.ArrayList;
import java.util.List;

public class BaseballReferee {

    private final List<Integer> hitterNumbers;
    private List<Integer> pitcherNumbers;

    private static final String STRIKEOUT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private static int strikeCount = 0;
    private static int ballCount = 0;

    public BaseballReferee(List<Integer> hitterNumbers, List<Integer> pitcherNumbers) {
        this.hitterNumbers = hitterNumbers;
        this.pitcherNumbers = pitcherNumbers;
    }

    public void changePitcherNumbers(List<Integer> numbers) {
        pitcherNumbers = numbers;
    }

    public boolean strikeout() {
        resetCount();
        checkBaseball();
        if (strikeCount == 3) {
            System.out.println(STRIKEOUT_MESSAGE);
            return true;
        }
        printResult();
        return false;
    }

    public void checkBaseball() {
        for (int hitterIndex = 0; hitterIndex < hitterNumbers.size(); hitterIndex++) {
            strike(hitterIndex);
            ball(hitterIndex);
        }
    }

    public Integer getStrikeCount() {
        return strikeCount;
    }

    public Integer getBallCount() {
        return ballCount;
    }

    private void printResult() {
        printNothing();
        printStrikeCount();
        printBallCount();
        System.out.println();
    }

    private void printStrikeCount() {
        if (strikeCount > 0) {
            System.out.print(strikeCount + STRIKE + " ");
        }
    }

    private void printBallCount() {
        if (ballCount > 0) {
            System.out.print(ballCount + BALL);
        }
    }

    private void printNothing() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING);
        }
    }

    private void strike(int index) {
        if (hitterNumbers.get(index).equals(pitcherNumbers.get(index))) {
            strikeCount++;
        }
    }

    private void ball(int hitterIndex) {
        for (int pitcherIndex = 0; pitcherIndex < pitcherNumbers.size(); pitcherIndex++) {
            checkBall(hitterIndex, pitcherIndex);
        }
    }

    private void checkBall(int hitterIndex, int pitcherIndex) {
        if (hitterIndex != pitcherIndex && hitterNumbers.get(hitterIndex).equals(pitcherNumbers.get(pitcherIndex))) {
            ballCount++;
        }
    }

    private void resetCount() {
        strikeCount = 0;
        ballCount = 0;
    }
}
