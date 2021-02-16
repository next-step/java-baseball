package baseball.view;

import static baseball.view.ViewStringContants.*;

public class OutputView {
    public static void inputNumber() {
        System.out.println(INPUT_NUMBERS.toString());
    }

    public static void result() {
        System.out.println(GAME_END.toString());
    }

    public static void end() {
        System.out.println(ASK_REGAME.toString());
    }
}
