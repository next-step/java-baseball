import java.util.HashMap;

public class BaseballGame implements Game {
    private int strike;
    private int ball;

    @Override
    public void run() {
        printGameStartMessage();
        initScore();
        BaseballComputer computer = new BaseballComputer();
        BaseballUser user = new BaseballUser();
        while (!isThreeStrike()) {
            initScore();
            user.baseballUserInput();
            compareNumbers(user.getNumbers(), computer.getNumbers());
            printResult();
        }
        printGameEndMessage();
    }

    @Override
    public void printGameStartMessage() {
        System.out.println(SystemMessage.BASEBALL_GAME_START_MESSAGE);
    }

    @Override
    public void printGameEndMessage() {
        System.out.println(SystemMessage.BASEBALL_GAME_END_MESSAGE);
    }

    private void initScore() {
        strike = 0;
        ball = 0;
    }

    private Boolean isThreeStrike() {
        if (strike == 3) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void compareNumbers(HashMap<Integer, Integer> userNumbers,
                                HashMap<Integer, Integer> computerNumbers) {
        for (int number : userNumbers.keySet()) {
            if (computerNumbers.containsKey(number)) {
                updateScore(userNumbers.get(number), computerNumbers.get(number));
            }
        }
    }

    private void updateScore(int userNumber, int computerNumber) {
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
        if (!(ball > 0 || strike > 0)) {
            System.out.printf("낫싱");
        }
        System.out.println();
    }
}