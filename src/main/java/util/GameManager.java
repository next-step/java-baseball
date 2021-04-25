package util;

public class GameManager {
	private static GameManager gameManager = null;

	private final String answer;

	private GameManager() {
		this.answer = GameUtil.getRandomNumber();
	}

	public static GameManager getInstance() {
		if (gameManager == null) {
			gameManager = new GameManager();
		}
		return gameManager;
	}

	public String getAnswer() {
		return this.answer;
	}

}
