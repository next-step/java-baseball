package io.mwkwon.baseball;

import java.util.Scanner;

/**
 * 숫자 야구 게임 실행 class
 *
 * @author mwkwon
 * @version 1.0: 최초 구현
 */
public class BaseBallGameMain {

    /**
     * 숫자 야구 게임 실행 main method
     *
     * @param args
     */
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        UIController uiController = new UIController(new Scanner(System.in), baseBallGame);
        String computerNumbers = baseBallGame.createComputerNumbers();
        GameControlVO gameControlVO = new GameControlVO();
        gameControlVO.setComputerNumbers(computerNumbers);
        do {
            String userNumbers = uiController.requestInputData(GameProgressInfo.REQUEST_NUMBERS);
            baseBallGame.executeGame(gameControlVO, userNumbers);
            uiController.printGameResult(gameControlVO, GameProgressInfo.QUESTION_NEW_GAME);
        } while (gameControlVO.getGameFlag() < 2);
    }
}
