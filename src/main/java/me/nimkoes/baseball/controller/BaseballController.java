package me.nimkoes.baseball.controller;

import me.nimkoes.baseball.MainLauncher;
import me.nimkoes.baseball.service.BaseballService;
import me.nimkoes.baseball.view.PlayerInterface;


public class BaseballController {

    private final PlayerInterface playerInterface;
    private final BaseballService baseballService;

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
        // 새 게임이 시작하면 gameOver 상태를 false 로 세팅
        baseballService.gameStart();

        // 새 게임 시작시 새로운 난수를 생성해서 저장
        baseballService.makeRandomNumber();
    }

    private void playBall() {
        do {
            userInput = playerInterface.inputNumber();  // 사용자 입력

            playerInterface.printCountMessage(
                    baseballService.getStrikeCount(userInput),
                    baseballService.getBallCount(userInput)
            );  // 비교 결과 출력

        } while (!baseballService.isGameOver());

        playerInterface.printEndingMessage(MainLauncher.LENGTH_OF_NUMBER);
    }

}
