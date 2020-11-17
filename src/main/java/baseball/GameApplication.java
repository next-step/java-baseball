package baseball;

import baseball.rule.GameManager;
import baseball.ui.GameUI;

public class GameApplication {
    public static void main(String[] args) {
        GameUI gameUI = new GameUI(new GameManager());
        gameUI.start();
    }
}
