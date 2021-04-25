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
        if (match(number, 3))
            strike++;
        if (match(number, 2))
            strike++;
        if (match(number, 1))
            strike++;
        return new Score(strike, 0);
    }

    private boolean match(int number, int pos) {
        if (pos == 3) {
            return number / 100 == opponent / 100;
        } else if (pos == 2) {
            return number / 10 % 10 ==  opponent / 10 % 10;
        } else if (pos == 1) {
           return number % 10 == opponent % 10;
        }
        throw new IllegalPositionException();
    }

}
