package baseball.constants;

public class GameConstants {
	public static final String REGEX_ALLOW_PLAYER_INPUT = "^[0-9]{3}$";
	public static final String REGEX_GAME_STATUS_INPUT = "^[1-2]{1}$";

	public static final int ALLOW_PLAYER_NUMBER_MAX_LENGTH = 3;
	public static final int ALLOW_PLAYER_NUMBER_BOUND = 10;

	public static final int GAME_STATUS_REPLAY = 1;
	public static final int GAME_STATUS_STOP = 2;

	public static final int MAX_COUNT_STRIKE = 3;

	public static final String MESSAGE_INPUT_USER_NUMBER = "숫자를 입력해주세요: ";
	public static final String MESSAGE_INPUT_USER_GAME_STATUS = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.%n";
	public static final String MESSAGE_MATCH_NOTHING = "낫싱";
	public static final String MESSAGE_MATCH_EVERYTHING = "%d개의 숫자를 모두 맞히셨습니다! 게임종료%n";
	public static final String MESSAGE_MATCH_STRIKE = "%d 스트라이크 ";
	public static final String MESSAGE_MATCH_BALL = "%d 볼";
}
