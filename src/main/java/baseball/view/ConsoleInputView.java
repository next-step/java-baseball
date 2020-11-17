package baseball.view;

import baseball.model.Numbers;
import baseball.model.Number;
import baseball.model.WinningNumbers;
import baseball.util.StringToNumberList;

import java.util.Scanner;

public class ConsoleInputView {
    private static final String READ_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String READ_WINNING_NUMBER_MESSAGE = "정답 숫자를 입력해주세요 : ";
    private static final String GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final Scanner CONSOLE = new Scanner(System.in);

    private ConsoleInputView() { }

    public static Numbers readNumbers() {
        final String inputValue = readStringWithMessage(READ_NUMBER_MESSAGE);
        return StringToNumberList.transform(inputValue);
    }

    public static WinningNumbers readWinningNumbers() {
        final String inputValue = readStringWithMessage(READ_WINNING_NUMBER_MESSAGE);
        return new WinningNumbers(StringToNumberList.transform(inputValue));
    }

    public static int readRestart() {
        final int inputValue = readIntWithMessage(GAME_RESTART);
        return inputValue;
    }

    private static String readStringWithMessage(final String message) {
        ConsoleOutputView.print(message);
        return readString();
    }

    private static int readIntWithMessage(final String message) {
        ConsoleOutputView.print(message);
        return readInt();
    }

    private static String readString() {
        final String readValue = CONSOLE.nextLine();
        return readValue;
    }

    private static int readInt() {
        final int readValue = CONSOLE.nextInt();
        return readValue;
    }
}
