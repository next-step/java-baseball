package baseball.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String CONTINUE_YES = "1";

    public static String getNumbers() {
        System.out.print(NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public static boolean getContinue() {
        System.out.println(END_MESSAGE);
        System.out.println(CONTINUE_MESSAGE);
        return scanner.nextLine().equals(CONTINUE_YES);
    }

}
