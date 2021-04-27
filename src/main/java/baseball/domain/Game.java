package baseball.domain;

public interface Game {
	/**
	 * 게임을 시작한다.
	 */
	void start(Umpire umpire);

	/**
	 * 게임을 초기화한다.
	 */
	void init();

	/**
	 * 게임을 플레이한다.
	 */
	void play();

	/**
	 * 게임의 상태를 반환한다.
	 * @return GameStatus
	 */
	GameStatus getGameStatus();
}
