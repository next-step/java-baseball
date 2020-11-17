package baseball.domain;

/**
 * Adversary 인터페이스를 구현한 클래스로 정답을 랜덤으로 생성한다.
 *
 * @author  Yonggu Han
 */
public class Computer implements Adversary {

    private Number answer;

    @Override
    public Number chooseNumber() {
        answer = Number.generateRandomNumber(Game.BASEBALL_NUMBER_SIZE);
        return answer;
    }

    @Override
    public Hint getHint(Number number) {
        return new Hint(answer, number);
    }
}
