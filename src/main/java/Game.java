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
        int input;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
            input = Integer.parseInt(scanner.nextLine());
        } while (input != 1 && input != 2);
        return GameState.getState(input);
    }

    private void printResult(GuessResult guessResult) {
        System.out.println(guessResult.toString());
    }

}
