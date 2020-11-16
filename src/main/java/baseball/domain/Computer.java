package baseball.domain;

public class Computer implements Adversary {

    private Numbers answer;

    @Override
    public Numbers chooseNumbers() {
        answer = Numbers.generateRandomNumbers(Game.BASEBALL_NUMBERS_SIZE);
        return answer;
    }
}
