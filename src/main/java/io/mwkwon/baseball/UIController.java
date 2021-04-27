package io.mwkwon.baseball;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 화면 출력 담당 class
 *
 * @author  mwkwon
 * @version 1.0: 최초 구현
 *
 */
public class UIController {

    private Scanner scanner;
    private BaseBallGame baseBallGame;
    public static final int MAX_ERROR_COUNT = 10;

    private int errorCount;

    public UIController(Scanner scanner, BaseBallGame baseBallGame) {
        this.scanner = scanner;
        this.baseBallGame = baseBallGame;
    }

    /**
     * scanner를 활용하여 사용자에게 데이터는 받는 method
     * gmaePregressInfo enum에 정의된 문자열을 출력 및 유효성 검사 진행
     * @param gameProgressInfo 결과 출력을 위한 게임 진행 정보 enum
     * @return 사용자 입력 데이터
     */
    public String requestInputData(GameProgressInfo gameProgressInfo) {
        System.out.printf(gameProgressInfo.getRequestPrintString());
        String inputData = scanner.nextLine();
        if (!this.validInputString(inputData, gameProgressInfo.getRegex(), gameProgressInfo.getStrLength())) {
            errorCount++;
            this.checkErrorCount();
            System.out.println(gameProgressInfo.getFailPrintString());
            this.requestInputData(gameProgressInfo);
        }
        errorCount = 0;
        return inputData;
    }

    /**
     * 사용자 입력 데이터와 컴퓨터가 생성한 숫자를 비교한 결과를 출력하는 method
     * @param gameControlVO 사용자 입력 데이터와 컴퓨타가 생성한 숫자 비교 결과
     * @param gameProgressInfo 결과 출력을 위한 게임 진행 정보 enum
     */
    public void printGameResult(GameControlVO gameControlVO, GameProgressInfo gameProgressInfo) {
        if (gameControlVO.getStrikeCount() == 3) {
            String gameFlag = requestInputData(gameProgressInfo);
            this.checkContinueGame(gameControlVO, Integer.valueOf(gameFlag));
            return;
        }
        StringBuilder builder = new StringBuilder();
        this.printHint(gameControlVO, builder);
        System.out.println(builder.toString());
    }


    /**
     * 사용자가 입력한 데이터에 대한 유효성 검사
     * @param inputString: 사용자 입력 String
     * @param regex: 유효성 체크를 위한 정규 표현식
     * @param strLength: 유효성 체크를 위한 문자열 길이 값
     * @return: 사용 가능 입력 String인 경우 true, 아닌 경우 false
     */
    public boolean validInputString(String inputString, String regex, int strLength) {
        if (inputString.length() != strLength) {
            return false;
        }
        String targetString = this.removeDuplicateString(inputString);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(targetString);
        return matcher.matches();
    }

    /**
     * 입력 에러 횟수 체크. 잘못된 값 10회 입력 시 프로그램 종료 처리
     */
    private void checkErrorCount() {
        if (this.errorCount >= MAX_ERROR_COUNT) {
            System.out.printf("잘못된 입력값이 10회 입력되었습니다. 프로그램을 종료합니다.");
            System.exit(1);
        }
    }

    /**
     * 사용자가 입력한 데이터에 중복 문자 제거
     * @param inputString: 사용자 입력 String
     * @return 중복 제거가 완료된 String
     */
    private String removeDuplicateString(String inputString) {
        if (inputString.length() == 1) {
            return inputString;
        }
        if (inputString.substring(1).contains(inputString.substring(0, 1))) {
            return removeDuplicateString(inputString.substring(1));
        }
        return inputString.substring(0, 1) + removeDuplicateString(inputString.substring(1));
    }

    /**
     * 사용자에게 힌트 정보를 출력 데이터 생성 method
     * @param gameControlVO 사용자 입력 데이터와 컴퓨타가 생성한 숫자 비교 결과
     * @param builder 사용자에게 출력할 문자열을 만들 StringBuilder 객체
     */
    private void printHint(GameControlVO gameControlVO, StringBuilder builder) {
        if (gameControlVO.getStrikeCount() == 0 & gameControlVO.getBallCount() == 0) {
            builder.append("낫싱");
            return;
        }
        if (gameControlVO.getStrikeCount() > 0) {
            builder.append(gameControlVO.getStrikeCount()).append("스트라이크");
        }
        if (gameControlVO.getBallCount() > 0) {
            builder.append(gameControlVO.getBallCount()).append("볼");
        }
    }

    /**
     * 게임 계속 진행여부 확인
     * 게임 플레이어가 2를 입력하는 경우 새로운 computerNumbers 계산하여 게임을 진행한다.
     * @param gameFlag : 게임 계속 진행여부 확인 flag 값
     */
    private void checkContinueGame(GameControlVO gameControlVO, int gameFlag) {
        if (gameFlag == 1) {
            String computerNumbers = baseBallGame.createComputerNumbers();
            gameControlVO.setComputerNumbers(computerNumbers);
        }
        gameControlVO.setGameFlag(gameFlag);
    }
}
