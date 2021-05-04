package domain.core;

import java.util.List;

public class Baseball extends Game {
    private final InputNumber inputNumber;
    private boolean isGaming;
    private int strikeCount;
    private StrikeCounter strikeCounter;
    private BallCounter ballCounter;

    private Baseball() {
        inputNumber = InputNumber.newInstance();
    }

    public static Baseball newInstance() {
        return new Baseball();
    }

    private void init() {
        isGaming = true;
        NumberGenerator numberGenerator = NumberGenerator.newInstance();
        List<Integer> answer = numberGenerator.getAnswer();
        strikeCounter = StrikeCounter.of(answer);
        ballCounter = BallCounter.of(answer);
    }

    @Override
    public void start() {
        init();
        while (isGaming) {
            List<Integer> input = this.inputNumber.getInput();
            this.strikeCount = strikeCounter.getStrikeCount(input);
            int ballCount = ballCounter.getBallCount(input);
            print(strikeCount, ballCount);
            end();
        }
    }

    private void print(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
        if (strikeCount != 0) {
            System.out.printf("%d스트라이크%n", strikeCount);
        }
        if (ballCount != 0) {
            System.out.printf("%d볼%n", ballCount);
        }
    }

    @Override
    public void end() {
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isGaming = false;
        }
    }
}
