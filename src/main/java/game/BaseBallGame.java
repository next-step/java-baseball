package game;

public class BaseBallGame {
    public void startGame() {
        Hitter hitter = new Hitter();
        Pitcher pitcher = new Pitcher();
        startGame(hitter, pitcher);
    }

    private void startGame(Hitter hitter, Pitcher pitcher) {
        System.out.println("정답: " + hitter.getBallList());
        System.out.println("입력 값: " + pitcher.getThrowBallList());
    }
}
