package baseball;

import baseball.game.NumberBaseBall;
import baseball.ui.UiSystem;
import baseball.ui.impl.ConsoleUiSystem;

public class Program {
    public static void main(String[] args) {

        UiSystem uiSystem = new ConsoleUiSystem();
        NumberBaseBall numberBaseBall = new NumberBaseBall(uiSystem);
        numberBaseBall.run();
    }

}
