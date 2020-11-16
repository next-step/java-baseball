package baseball.ui;

import baseball.GameManager;
import baseball.exceptions.QuitException;

import java.util.Scanner;

public class GameUI {
    private static final Scanner scanner = new Scanner(System.in);
    private final GameManager gm;

    public GameUI(GameManager gameManager) {
        gm = gameManager;
    }

    public void start() {
        while(true) {
            System.out.println("숫자를 입력해주세요(종료는 'q' 입력) : ");
            String inputStr = scanner.nextLine();

            quitGame(inputStr);

            // TODO: 핵심 로직 구현은 여기에 한다.
        }
    }

    private void quitGame(String inputStr) {
        if(inputStr.equals("q")) {
            String quitMessage = "야구 게임을 종료합니다.";
            System.out.println(quitMessage);
            throw new QuitException(quitMessage);
        }
    }
}
