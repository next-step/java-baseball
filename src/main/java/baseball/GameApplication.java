package baseball;

import baseball.exceptions.QuitException;
import baseball.rule.GameManager;
import baseball.ui.GameUI;

public class GameApplication {
    private static final GameManager gm = new GameManager();

    public static void main(String[] args) {
        GameUI gameUI = new GameUI(new GameManager());
        try {
            gameUI.start();
        } catch (QuitException e) {}
    }
}
