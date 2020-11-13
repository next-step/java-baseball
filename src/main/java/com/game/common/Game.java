package com.game.common;

public interface Game {

    /**
     * 게임 시작
     */
    void start();

    /**
     * 게임 새로 시작
     */
    void restart();

    /**
     * 게임 종료
     */
    void exit();

    /**
     * 입력 값 유효성 검사
     * @param input 입력 값
     * @return 입력 값 유효성 여부
     */
    boolean isValidInput(String input);
}
