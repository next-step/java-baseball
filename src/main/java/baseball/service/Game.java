package baseball.service;

import baseball.domain.Score;
import baseball.exception.IllegalPositionException;

public class Game {

    private final int opponent;

    public Game() {
        opponent = createRandomNumber();
    }

    public Game(int opponent) {
        this.opponent = opponent;
    }

    public Score play(int numbers) {
        int strike = getStrike(numbers);
        int ball = getBall(numbers);

        if (strike == 0 && ball == 0)
            return new Score(strike, 4);

        return new Score(strike, ball);
    }

    private int createRandomNumber() {
        int[] numbers = new int[3];

        numbers[0] = (int) (Math.random() * 9) + 1;
        numbers[1] = (int) (Math.random() * 10);
        numbers[2] = (int) (Math.random() * 10);

        StringBuilder builder = new StringBuilder();
        builder.append(numbers[0]);
        builder.append(numbers[1]);
        builder.append(numbers[2]);

        return Integer.valueOf(builder.toString());
    }

    private int getBall(int numbers) {
        int ball = 0;
        if (match(getNumber(numbers, 1), 2) || match(getNumber(numbers, 1), 3))
            ball++;
        if (match(getNumber(numbers, 2), 1) || match(getNumber(numbers, 2), 3))
            ball++;
        if (match(getNumber(numbers, 3), 1) || match(getNumber(numbers, 3), 2))
            ball++;
        return ball;
    }

    private int getStrike(int numbers) {
        int strike = 0;
        for (int i = 1; i <= 3; i++)
            strike = checkStrikeCount(numbers, strike, i);
        return strike;
    }

    private int checkStrikeCount(int numbers, int count, int pos) {
        if (match(getNumber(numbers, pos) , pos))
            count++;
        return count;
    }

    private int getNumber(int numbers, int pos) {
        if (pos == 3)
            return numbers / 100;
        else if ((pos == 2))
            return numbers / 10 % 10;
        else if (pos == 1)
            return numbers % 10;
        throw new IllegalPositionException();
    }

    private boolean match(int number, int pos) {
        return number == getNumber(opponent, pos);
    }

}
