package baseball.service;

public class BaseballGameService {

	public static final Integer GAME_RESTART = 1;
	public static final Integer GAME_END = 2;

	public static boolean isStartGame(Integer gameStartState) {

		return gameStartState.equals(GAME_RESTART);
	}
}
