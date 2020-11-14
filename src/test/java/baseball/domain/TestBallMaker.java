package baseball.domain;

/**
 * 테스트를 위한 BallMaker
 */
public class TestBallMaker implements BallMaker {
    @Override
    public Balls generate() {
        String numbers = "192";
        return new Balls(numbers);
    }
}
