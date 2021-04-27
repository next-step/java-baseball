package io.mwkwon.baseball;
/**
 * 화면 출력 문자열 및 입력 값 유효성 검사를 위한 정규 표현식, 문자열 길이값 저장 enum
 *
 * @author  mwkwon
 * @version 1.0: 최초 구현
 *
 */
public enum GameProgressInfo {
    REQUEST_NUMBERS(
            "숫자를 입력해주세요:"
            , "잘못된 입력값!! 1부터 9까지 서로 다른 3개의 숫자만 입력 가능합니다. "
            + "\n다시 입력해주세요. 잘못된 값 10회 입력 시 프로그램이 종료됩니다."
            , "[1-9]{3}"
            , 3),
    QUESTION_NEW_GAME(
            "3개의숫자를모두맞히셨습니다!게임종료\n게임을 새로 시작 하려면1, 종료 하려면 2를 입력하세요."
            , "잘못된 입력값!! 1 또는 2만 입력 가능합니다. 다시 입력해주세요."
            + "\n다시 입력해주세요. 잘못된 값 10회 입력 시 프로그램이 종료됩니다."
            , "[1-2]{1}"
            , 1);

    private String requestPrintString;
    private String failPrintString;
    private String regex;
    private int strLength;

    GameProgressInfo(String requestPrintString, String failPrintString, String regex, int strLength) {
        this.requestPrintString = requestPrintString;
        this.failPrintString = failPrintString;
        this.regex = regex;
        this.strLength = strLength;
    }

    public String getRequestPrintString() {
        return requestPrintString;
    }

    public String getFailPrintString() {
        return failPrintString;
    }

    public String getRegex() {
        return regex;
    }

    public int getStrLength() {
        return strLength;
    }
}
