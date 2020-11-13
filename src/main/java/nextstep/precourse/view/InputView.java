package nextstep.precourse.view;

import nextstep.precourse.ViewUtils;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NEWGAME_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getNumber() {
        ViewUtils.print(INPUT_NUMBER_MESSAGE);

        return ViewUtils.readLine();
    }

    public int getContinue() {
        ViewUtils.printLine(NEWGAME_OR_EXIT_MESSAGE);

        return ViewUtils.readLineToInt();
    }
}
