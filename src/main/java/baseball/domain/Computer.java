package baseball.domain;

public class Computer implements Adversary {

    private Number answer;

    @Override
    public Number chooseNumber() {
        answer = Number.generateRandomNumber(Game.BASEBALL_NUMBER_SIZE);
        return answer;
    }
}
