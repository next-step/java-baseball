import baseball.BaseballConstants;
import baseball.BaseballNumbers;
import baseball.BaseballResults;
import computer.RandomBaseballGenerator;
import user.BaseballUser;

import java.util.Scanner;

public class BaseballGame {
    private static final String CONTINUE = "1";

    private Scanner scanner;
    private RandomBaseballGenerator randomBaseballGenerator;
    private BaseballUser baseballUser;
    private boolean isContinue;

    public BaseballGame(Scanner scanner, RandomBaseballGenerator randomBaseballGenerator, BaseballUser baseballUser) {
        this.scanner = scanner;
        this.randomBaseballGenerator = randomBaseballGenerator;
        this.baseballUser = baseballUser;
        this.isContinue = true;
    }

    public void start() {
        while (isContinue) {
            playBall();
            isContinue = requestContinueGame();
        }
    }

    private boolean requestContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = scanner.nextLine();
        if (userInput.equals(CONTINUE)) {
            return true;
        }
        return false;
    }
    
    private void playBall() {
        boolean isEndGame = false;
        BaseballNumbers baseballNumbers = randomBaseballGenerator.apply();
        while (!isEndGame) {
            BaseballNumbers userBaseballNumbers = createUserBaseballNumbersByInput();
            BaseballResults baseballResults = compareTwoBaseballNumbers(baseballNumbers, userBaseballNumbers);
            isEndGame = checkResultAndFinishFlagIfRightAnswer(baseballResults);
        }
    }
    
    private BaseballNumbers createUserBaseballNumbersByInput() {
        BaseballNumbers userBaseballNumbers = null;
        while (userBaseballNumbers == null) {
            userBaseballNumbers = userInput();
        }
        return userBaseballNumbers;
    }
    
    private BaseballNumbers userInput() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            return baseballUser.inputNumber(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private BaseballResults compareTwoBaseballNumbers(BaseballNumbers b1, BaseballNumbers b2) {
        return b1.compareTo(b2);
    }

    private boolean checkResultAndFinishFlagIfRightAnswer(BaseballResults baseballResults) {
        if (baseballResults.isAnswer()) {
            System.out.println(String.format("%d의 숫자를 모두 맞히셨습니다! 게임종료", BaseballConstants.BASEBALL_NUMBER_SIZE));
            return true;
        }

        System.out.println(baseballResults);
        return false;
    }
}
