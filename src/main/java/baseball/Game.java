package baseball;

public class Game {
    public static void main(String[] args) {
        BaseBall newGame = new BaseBall();

        while (!newGame.stop) {
            newGame.start();
        }
    }
}
