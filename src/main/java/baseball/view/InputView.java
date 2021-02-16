package baseball.view;

import baseball.domain.BaseballDigit;
import baseball.domain.BaseballDigits;
import baseball.domain.GameCommand;

import java.util.Scanner;

public class InputView {
    private static final String NUMBER_INPUT_GUIDE_MESSAGE = "숫자를 입력해 주세요: ";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력 값입니다. ";
    private static final String SELECT_INPUT_GUIDE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static BaseballDigit getBaseballNumbers() {
        try {
            System.out.print(NUMBER_INPUT_GUIDE_MESSAGE);
            String baseballNumbers = scanner.nextLine();
            BaseballDigit baseballDigit = new BaseballDigit(baseballNumbers);
            return baseballDigit;
        } catch (IllegalArgumentException e) {
            return getBaseballNumbers();
        }
    }

    public static GameCommand restartGame() {
        try {
            System.out.println(SELECT_INPUT_GUIDE_MESSAGE);
            String input = scanner.nextLine();
            return GameCommand.check(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_INPUT_MESSAGE);
            return restartGame();
        }
    }
}
