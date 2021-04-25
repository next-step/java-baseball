package me.nimkoes.baseball.controller;

import me.nimkoes.baseball.MainLauncher;
import me.nimkoes.baseball.service.BaseballService;
import me.nimkoes.baseball.view.PlayerInterface;


public class BaseballController {

    private final PlayerInterface playerInterface;
    private final BaseballService baseballService;

    private int strikeCount;
    private int ballCount;

    private String userInput;

    public BaseballController(PlayerInterface playerInterface, BaseballService baseballService) {
        this.playerInterface = playerInterface;
        this.baseballService = baseballService;
    }

    /*
     * 숫자 야구 게임 도입부
     */
    public void run() {
        do {
            setUp();     // 초기값 세팅
            playBall();  // 숫자 야구 게임 시작
        } while (playerInterface.checkContinue());
    }

    /*
     * 새 게임을 시작할 때 초기값 세팅
     */
    private void setUp() {
        this.strikeCount = 0;
        this.ballCount = 0;
        this.userInput = "";

        // 새 게임 시작시 새로운 난수를 생성해서 저장
        baseballService.setRandomNumber();
    }

    private void playBall() {
        do {
            userInput = playerInterface.inputNumber();  // 사용자 입력
            strikeCount = baseballService.getStrikeCount(userInput);    // strike 계산
            ballCount = baseballService.getBallCount(userInput);        // ball 계산

            playerInterface.printCountMessage(strikeCount, ballCount);  // 비교 결과 출력

        } while (strikeCount != MainLauncher.LENGTH_OF_NUMBER);

        playerInterface.printEndingMessage(MainLauncher.LENGTH_OF_NUMBER);
    }

}
