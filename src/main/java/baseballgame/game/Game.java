package baseballgame.game;

public class Game {
    private final GameNumber answerGameNumber;

    public Game() {
        this.answerGameNumber = GameNumber.generateRandomly();
    }

    public GameResult submit(GameNumber inputGameNumber) {
        return answerGameNumber.compare(inputGameNumber);
    }
}
