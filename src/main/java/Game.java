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

    public Score play(int number) {
        int strike = 0;
        if (number / 100 == opponent / 100)
            strike++;
        if (number / 10 % 10 ==  opponent / 10 % 10)
            strike++;
        if (number % 10 == opponent % 10)
            strike++;
        return new Score(strike, 0);
    }
}
