package baseball.view;

import baseball.BaseballGame;

import java.util.Objects;
import java.util.Scanner;

public class ReceivingPlayAgainAnswer {
    private final Scanner scanner;

    public ReceivingPlayAgainAnswer(Scanner scanner) {
        this.scanner = scanner;
    }

    public int receivePlayAgainAnswer() {
        String answer;
        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            answer = scanner.next();
        } while (!isSatisfiedAnswer(answer));
        return Integer.parseInt(answer);
    }

    private boolean isSatisfiedAnswer(String answer) {
        return Objects.equals(Integer.toString(BaseballGame.RESTART_CODE), answer) ||
                Objects.equals(Integer.toString(BaseballGame.EXIT_CODE), answer);
    }
}
