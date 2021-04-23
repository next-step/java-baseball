package baseball;

import baseball.play.PlayService;

public class BaseBallApplication {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();

		PlayService playService = appConfig.playService();
		playService.playBall();
	}

}
