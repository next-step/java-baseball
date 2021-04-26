package baseball;

public class BaseBallGameApplication {
	public static void main(String[] args) {
		int isGaming;
		do {
			BaseBallGame baseBallGame = new BaseBallGame();
			isGaming = baseBallGame.gameStart();
		} while (isGaming == BaseBallGame.RESTART_GAME);
	}
}
