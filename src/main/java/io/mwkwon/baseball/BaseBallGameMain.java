package io.mwkwon.baseball;

/**
 * 숫자 야구 게임 실행 class
 *
 * @author  mwkwon
 * @version 1.0: 최초 구현
 *
 */
public class BaseBallGameMain {
    /**
     * 숫자 야구 게임 실행 main method
     * @param args
     */
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        String computerNumbers = baseBallGame.createComputerNumbers();
    }
}
