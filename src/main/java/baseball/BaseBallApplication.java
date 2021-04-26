package baseball;

import baseball.play.PlayService;

public class BaseBallApplication {
	public static final int BALL_COUNT = 3;

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		PlayService playService = appConfig.playService();
		playService.playBall();
	}
}
