package game;

public class BaseBallGame {
    public void startGame() {
        Hitter hitter = new Hitter();
        Pitcher pitcher = new Pitcher();
        startGame(hitter, pitcher);
    }

    private void startGame(Hitter hitter, Pitcher pitcher) {
    }
}
