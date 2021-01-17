package baseball;

import java.util.InputMismatchException;

public class Game {
    private static final int RESTART = 1;
    private static final int END = 2;
    private static final String RESTART_MSG = "게임을 새로 시작하려면 " + RESTART + ", 종료하려면 " + END + "를 입력하세요.\n";
    private static final String NUMBER_MSG = "숫자를 입력해주세요 : ";
    private static final String WRONG_FORMAT_MSG = "잘못된 형식의 입력입니다.\n";
    private static final String UNEXPECTED_MSG = "예기치 않은 오류이므로 프로그램을 강제 종료합니다.\n";

    private final UserIO userIO;
    private final Number.Builder numberBuilder;

    public Game(UserIO userIO, Number.Builder numberBuilder) {
        this.userIO = userIO;
        this.numberBuilder = numberBuilder;
    }

    public boolean restart() {
        while (true) {
            try {
                int num = userIO.scanInt(RESTART_MSG);
                if (num == RESTART) {
                    return true;
                } else if (num == END) {
                    return false;
                }
            } catch (InputMismatchException e) {

            }
            userIO.printMsg(WRONG_FORMAT_MSG);
        }
    }
}
