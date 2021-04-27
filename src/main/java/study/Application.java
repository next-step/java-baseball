package study;


import study.baseball.BaseballGameManager;

import static study.common.GameMessages.GAME_END;

/**
 * @author bo-yoon
 */
public class Application {

    public static void main(String[] args) {

        boolean again = false;

        do {
            again = BaseballGameManager.startGame();
        } while (again);

        System.out.println(GAME_END);
    }
}
