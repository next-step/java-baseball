import java.util.HashMap;

public class BaseballGame implements Game {
    private int strike;
    private int ball;

    @Override
    public void gameRun() {
        gameStartMsg();
        initJudgements();
        BaseballComputer computer = new BaseballComputer();
        BaseballUser user = new BaseballUser();
        while (!isThreeStrike()) {
            initJudgements();
            user.userThreeIntegerInput();
            compareNumbers(user.getNumbers(), computer.getNumbers());
            printResult();
        }
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

    private Boolean isThreeStrike() {
        if (strike == 3) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void compareNumbers(HashMap<Integer, Integer> userNumbers, HashMap<Integer, Integer> computerNumbers) {
        for (int number : userNumbers.keySet()) {
            if (computerNumbers.containsKey(number)) {
                strikeOrBall(userNumbers.get(number), computerNumbers.get(number));
            }
        }
    }

    private void strikeOrBall(int userNumber, int computerNumber) {
        if (userNumber == computerNumber) {
            strike += 1;
        } else {
            ball += 1;
        }
    }

    private void printResult() {
        if (ball > 0) {
            System.out.printf("%d볼 ", ball);
        }
        if (strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }
        System.out.println();
    }
}