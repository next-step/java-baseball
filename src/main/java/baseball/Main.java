package baseball;

import baseball.domain.BaseballNumberGenerator;
import baseball.domain.BaseballNumberValidator;
import baseball.domain.GameChecker;
import baseball.view.ReceivingBaseballNumber;
import baseball.view.ReceivingPlayAgainAnswer;
import baseball.view.ResultScreen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        BaseballNumberValidator baseballNumberValidator = new BaseballNumberValidator();
        GameChecker gameChecker = new GameChecker();
        Scanner scanner = new Scanner(System.in);
        ReceivingBaseballNumber receivingBaseballNumber = new ReceivingBaseballNumber(scanner);
        ReceivingPlayAgainAnswer receivingPlayAgainAnswer = new ReceivingPlayAgainAnswer(scanner);
        ResultScreen resultScreen = new ResultScreen();

        BaseballGame baseballGame = new BaseballGame(baseballNumberGenerator, baseballNumberValidator, gameChecker,
                receivingBaseballNumber, receivingPlayAgainAnswer, resultScreen);
        baseballGame.play();
    }
}
