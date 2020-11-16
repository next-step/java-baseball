package domain;

public class BaseballMessage {
    public static final String STRIKE = "%d스트라이크";
    public static final String BALL = "%d볼";
    public static final String STRIKE_AND_BALL = "%d스트라이크 %d볼";
    public static final String NOTHING = "낫싱";
    public static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String DUPLICATE_NUMBER_OF_DIGIT_EXCEPTION_MESSAGE = "중복된 자릿수가 존재합니다.";
    public static final String INVALID_GAME_STATUS_EXCEPTION_MESSAGE = "게임 상태값이 유효하지 않습니다.";
    public static final String INVALID_NUMBER_OF_DIGIT_RANGE_EXCEPTION_MESSAGE = "자릿수 범위가 유효하지 않습니다.";
    public static final String NUMBER_NOT_THREE_DIGITS_EXCEPTION_MESSAGE = "세자리 숫자가 아닙니다.";
}
