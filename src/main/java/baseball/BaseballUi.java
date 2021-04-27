package baseball;

import java.util.Scanner;

public class BaseballUi {

    private final Scanner scanner;

    public BaseballUi(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * 매개변수로 받은 내용 메시지 출력.
     * @param message 출력하고 싶은 메시지.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * 숫자 입력 로직.
     * @return 사용자에게 입력 받은 숫자.
     */
    public String askNumber() {
        showMessage("숫자를 입력해주세요 : ");
        return scanner.next();
    }

    /**
     * 게임 종료시 메시지 출력.
     * @return 사용자에게 입력 받은 숫자.
     */
    public String askContinue() {
        showMessage("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        showMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.next();
    }
}
