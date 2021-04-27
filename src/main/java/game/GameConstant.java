package game;

public class GameConstant {

	/**
	 * 사용자 안내 상수 문자열
	 */
	public static final String INFO_ANSWER_RESULT = "모두 맞히졌습니다.";
	public static final String INFO_QUESTION_RESTART = "게임을 새로 시작하려면 1, 종려하려면 2를 입력하세요.";
	public static final String INFO_INPUT_NUMBER = "숫자를 입력해주세요 : ";

	/**
	 * 게임 상태
	 */
	public static final int RESTART = 1;
	public static final int EXIT = 2;
	public static final int NONE = -1;
	public static final int ANSWER = 3;
	
	/**
	 * 에러 문구
	 */
	public static final String ERR_DUPLICATE_VALUE = "중복된 값이 존재합니다";
	public static final String ERR_RANDOM_VALUE = "랜덤 값은 1 ~ 9까지 수여야 합니다";
	public static final String ERR_INPUT_LENGTH = "입력된 값의 길이는 반드시 3이어야 합니다";

	public static final int RANDOM_VALUE_MAX_LENGTH = 3;
	public static final String DELIMITER = " ";
}
