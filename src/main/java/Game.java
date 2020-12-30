import Model.GameState;
import Model.GuessResult;

import java.util.Scanner;

public class Game {

    private Computer computer;
    private UserInputScanner userInputScanner;

    public Game() {
        this.computer = new Computer();
        this.userInputScanner = new UserInputScanner();
    }

    public void playGame() {
        GuessResult guessResult;
        computer.selectRandomNumber();
        do {
            guessResult = computer.guessNumber(userInputScanner.scanInput());
            printResult(guessResult);
        } while (guessResult.getStrike() != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    public GameState askToContinue() {
        String input;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
            input = scanner.nextLine();
        } while (!isValidateInput(input));
        return GameState.getState(Integer.parseInt(input));
    }

    private void printResult(GuessResult guessResult) {
        System.out.println(guessResult.toString());
    }

    private boolean isValidateInput(String input) {
        if (!isInputInteger(input) || !isInput1Or2(input)) {
            System.out.println("올바르지 않은 인풋입니다. 1또는 2를 입력해 주세요.");
            return false;
        }
        return true;
    }

    private boolean isInputInteger(String input) {
        return input.matches("[0-9]+");
    }

    private boolean isInput1Or2(String input) {
        int inputToInteger = Integer.parseInt(input);
        if (inputToInteger != 1 && inputToInteger != 2)
            return false;
        return true;
    }
}
