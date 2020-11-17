package baseball.ui;

import baseball.rule.GameManager;
import baseball.exceptions.QuitException;
import baseball.rule.GameResult;
import baseball.utils.InputParser;

import java.util.Scanner;

public class GameUI {
    private static final Scanner scanner = new Scanner(System.in);
    private final GameManager gm;

    public GameUI(GameManager gameManager) {
        gm = gameManager;
    }

    public void start() {
        Integer[] inputNums;

        while(true) {
            String inputStr = scanInput();

            try {
                inputNums = reactInput(inputStr);
            } catch (IllegalArgumentException ex){
                continue;
            }

            GameResult result = gm.judge(inputNums);
            printResult(result);
        }
    }

    private String scanInput() {
        System.out.println("숫자를 입력해주세요(종료는 'q' 입력) : ");
        return scanner.nextLine();
    }

    private Integer[] reactInput(String inputStr) {
        try {
            return InputParser.parse(inputStr);
        } catch (IllegalArgumentException ex) {
            System.out.println("3자리 숫자를 입력해 주세요.");
            throw ex;
        } catch (QuitException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    private void printResult(GameResult result) {
        System.out.println("결과 : " + result);

        if(result.isEndOfGame()) {
            String quitMessage = "정답을 맞춰서 게임을 종료합니다.";
            System.out.println(quitMessage);
            throw new QuitException(quitMessage);
        }
    }
}
