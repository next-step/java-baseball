import java.util.HashMap;

public class BaseballGame implements Game {
    private int strike;
    private int ball;

    public BaseballGame() {
        initJudgements();
    }

    @Override
    public void gameRun() {
        gameStartMsg();
        BaseballComputer computer = new BaseballComputer();
        BaseballUser user = new BaseballUser();
        initJudgements();
        user.userThreeIntegerInput();
        gameEndMsg();
    }

    @Override
    public void gameStartMsg() {
        System.out.println("야구 게임 시작 !");
    }

    @Override
    public void gameEndMsg() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void initJudgements() {
        strike = 0;
        ball = 0;
    }
}
