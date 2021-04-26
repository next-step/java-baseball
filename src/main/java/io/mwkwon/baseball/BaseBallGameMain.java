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
    private static String continueFlag = "1";
    private static Scanner scanner = new Scanner(System.in);
    private static BaseBallGame baseBallGame = new BaseBallGame();
    private static String computerNumbers = baseBallGame.createComputerNumbers();

    /**
     * 숫자 야구 게임 실행 main method
     * @param args
     */
    public static void main(String[] args) {
        while (baseBallGame.isContinueGame(continueFlag)) {
            String userNumbers = requestInputData(GameProgressInfo.REQUEST_NUMBERS);
            GameResult gameResult = baseBallGame.executeGame(computerNumbers, userNumbers);
            printGameResult(gameResult, GameProgressInfo.QUESTION_NEW_GAME);
        }
    }

    /**
     * scanner를 활용하여 사용자에게 데이터는 받는 method
     * gmaePregressInfo enum에 정의된 문자열을 출력 및 유효성 검사 진행
     * @param gameProgressInfo 결과 출력을 위한 게임 진행 정보 enum
     * @return 사용자 입력 데이터
     */
    private static String requestInputData(GameProgressInfo gameProgressInfo) {
        System.out.printf(gameProgressInfo.getRequestPrintString());
        String inputData = scanner.nextLine();
        if (!baseBallGame.validInputString(inputData, gameProgressInfo.getRegex(), gameProgressInfo.getStrLength())) {
            System.out.println(gameProgressInfo.getFailPrintString());
            requestInputData(gameProgressInfo);
        }
        return inputData;
    }

    /**
     * 사용자 입력 데이터와 컴퓨터가 생성한 숫자를 비교한 결과를 출력하는 method
     * @param gameResult 사용자 입력 데이터와 컴퓨타가 생성한 숫자 비교 결과
     * @param gameProgressInfo 결과 출력을 위한 게임 진행 정보 enum
     */
    private static void printGameResult(GameResult gameResult, GameProgressInfo gameProgressInfo) {
        if (gameResult.getStrikeCount() == 3) {
            continueFlag = requestInputData(gameProgressInfo);
            computerNumbers = baseBallGame.createComputerNumbers();
            return;
        }
        StringBuilder builder = new StringBuilder();
        printHint(gameResult, builder);
        System.out.println(builder.toString());
    }

    /**
     * 사용자에게 힌트 정보를 출력 데이터 생성 method
     * @param gameResult 사용자 입력 데이터와 컴퓨타가 생성한 숫자 비교 결과
     * @param builder 사용자에게 출력할 문자열을 만들 StringBuilder 객체
     */
    private static void printHint(GameResult gameResult, StringBuilder builder) {
        if (gameResult.getStrikeCount() == 0 & gameResult.getBallCount() == 0) {
            builder.append("낫싱").toString();
            return;
        }
        if (gameResult.getStrikeCount() > 0) {
            builder.append(gameResult.getStrikeCount()).append("스트라이크");
        }
        if (gameResult.getBallCount() > 0) {
            builder.append(gameResult.getBallCount()).append("볼");
        }
    }
}
