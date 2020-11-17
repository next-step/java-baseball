package org.dhlee.game.baseball.constant;

public class BaseballConstant {
    public static final Integer[] NUMBER_LIST= {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static final int NUMBER_LENGTH = 3;

    public static final String MESSAGE_ENTER_NUMBERS = "숫자를 입력해주세요 : ";
    public static final String MESSAGE_END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String MESSAGE_ENTER_CONTINUE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String MESSAGE_STRIKE_FORMAT = "%d스트라이크";
    public static final String MESSAGE_BALL_FORMAT = "%d볼";
    public static final String MESSAGE_NO_COUNT_FORMAT = "낫싱";

    public static final String EXCEPTION_MAX_LENGTH = "입력 글자의 길이는 3자리수 입니다.";
    public static final String EXCEPTION_NUMBER_FORMAT = "숫자 포맷이 아닙니다.";
    public static final String EXCEPTION_EQAUL_NUMBER = "동일한 숫자가 존재합니다.";

}
