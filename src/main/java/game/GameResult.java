package game;

public class GameResult {
    private static final int MAX_STRIKE_COUNT = 3;
    private int strikeCount = 0;

    private int ballCount = 0;

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public boolean isCorrect() {
        return getStrikeCount() == MAX_STRIKE_COUNT;
    }

    public boolean isNothing() {
        return getStrikeCount() == 0 && getBallCount() == 0;
    }

    public void printGameResult() {
        if (isCorrect()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (isNothing()) {
            System.out.println("낫싱");
            return;
        }

        printStrikeAndBall();
    }

    private void printStrikeAndBall() {
        if (getStrikeCount() != 0) {
            System.out.print(getStrikeCount() + " 스트라이크 ");
        }
        if (getBallCount() != 0) {
            System.out.print(getBallCount() + " 볼");
        }
        System.out.println();
    }
}
