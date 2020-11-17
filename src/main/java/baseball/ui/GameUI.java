package baseball.ui;

import baseball.rule.GameManager;
import baseball.rule.GameResult;
import baseball.exceptions.RestartGameException;
import baseball.exceptions.QuitException;
import baseball.utils.InputParser;

import java.util.Scanner;

public class GameUI {
    private static final Scanner scanner = new Scanner(System.in);
    private final GameManager gm;

    public GameUI(GameManager gameManager) {
        gm = gameManager;
    }

    public void start() {
        while(true) {
            if (eventLoop())
                break;
        }
    }

    private boolean eventLoop() {
        try {
            Integer[] inputNums = InputParser.parse(scanInput());
            printResult(gm.judge(inputNums));
        } catch (IllegalArgumentException ex) {
            printInvalidateInput();
        } catch (RestartGameException ex) {
            restartGame();
        } catch (QuitException ex) {
            printExitGame();
            return true;
        }
        return false;
    }

    private String scanInput() {
        System.out.println("숫자를 입력해주세요(종료는 'q' 입력) : ");
        return scanner.nextLine();
    }

    private void printInvalidateInput() {
        System.out.println("3자리 숫자를 입력해 주세요.");
    }

    private void printResult(GameResult gameResult) {
        System.out.println("결과 : " + gameResult);
        checkExit(gameResult);
    }

    private void checkExit(GameResult result) {
        if(!result.isEndOfGame())
            return;

        while(true) {
            String exitInput = scanExitInput();
            proceedExit(exitInput);
        }
    }

    private void proceedExit(String input) {
        if (input.equals("1")) {
            throw new RestartGameException();
        }
        else if(input.equals("2")) {
            throw new QuitException();
        }
        System.out.println("잘못 입력하셨습니다.");
    }

    private String scanExitInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine();
    }

    private void restartGame() {
        gm.generateAnswers();
        System.out.println("게임을 새로 시작합니다.");
    }

    private void printExitGame() {
        System.out.println("게임을 종료합니다.");
    }

}
