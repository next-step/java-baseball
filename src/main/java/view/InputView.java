package view;

import domain.BaseballGameMachine;
import domain.GameNumber;
import domain.GuessResult;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    public static int inputContinueNumber() {
        System.out.println("게임을 새로 시작할려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void guess(BaseballGameMachine baseballGameMachine) {
        boolean continueGuess = true;
        while (continueGuess) {
            GameNumber userGameNumber = getUserGameNumber();

            GuessResult guessResult = baseballGameMachine.getGuessResult(userGameNumber);

            OutputView.printResult(guessResult);

            continueGuess = baseballGameMachine.isContinueGuess(guessResult);
        }
    }

    private static GameNumber getUserGameNumber() {
        String userNumberRaw = InputView.inputUserNumber();
        return GameNumber.ofByRaw(userNumberRaw);
    }
}
