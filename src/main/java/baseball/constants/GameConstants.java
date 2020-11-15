package baseball.constants;

public class GameConstants {
	public static final String REGEX_ALLOW_PLAYER_INPUT = "^[0-9]{3}$";
	public static final String REGEX_GAME_STATUS_INPUT = "^[1-2]{1}$";

	public static final int ALLOW_PLAYER_NUMBER_MAX_LENGTH = 3;
	public static final int ALLOW_PLAYER_NUMBER_BOUND = 10;

	public static final int GAME_STATUS_REPLAY = 1;
	public static final int GAME_STATUS_STOP = 2;
}
