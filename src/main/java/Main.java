import baseball.BaseBallGame;

public class Main {
    public static void main(String[] args) {
        BaseBallGame game = new BaseBallGame();

        do {
            game.newGame();
            game.startGame();
        } while (game.wantAnotherGame());
    }
}
