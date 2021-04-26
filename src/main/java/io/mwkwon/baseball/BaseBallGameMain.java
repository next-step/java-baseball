package io.mwkwon.baseball;

import java.util.Scanner;

/**
 * 숫자 야구 게임 실행 class
 *
 * @author  mwkwon
 * @version 1.0: 최초 구현
 *
 */
public class BaseBallGameMain {

    private static Scanner scanner;
    private static BaseBallGame baseBallGame;

    public BaseBallGameMain() {
        scanner = new Scanner(System.in);
        baseBallGame = new BaseBallGame();
    }

    /**
     * 숫자 야구 게임 실행 main method
     * @param args
     */
    public static void main(String[] args) {
        String continueFlag = "1";
        BaseBallGame baseBallGame = new BaseBallGame();
        String computerNumbers = baseBallGame.createComputerNumbers();
        while (baseBallGame.isContinueGame(continueFlag)) {
            String userNumbers = requestInputData(GameProgressInfo.REQUEST_NUMBERS);
            GameResult gameResult = baseBallGame.executeGame(computerNumbers, userNumbers);
        }
    }


    private static String requestInputData(GameProgressInfo gameProgressInfo) {
        System.out.printf(gameProgressInfo.getRequestPrintString());
        String inputData = scanner.nextLine();
        if (!baseBallGame.validInputString(inputData, gameProgressInfo.getRegex())) {
            System.out.println(gameProgressInfo.getFailPrintString());
            requestInputData(gameProgressInfo);
        }
        return inputData;
    }
}
