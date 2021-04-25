import java.util.Random;

public class Game {

    private final int opponent;

    public Game() {
        Random random = new Random();
        opponent = random.nextInt(900) + 100;
    }

    public Game(int opponent) {
        this.opponent = opponent;
    }

    public int getOpponent() {
        return opponent;
    }

}
