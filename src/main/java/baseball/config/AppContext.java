package baseball.config;

import baseball.controller.GameController;
import baseball.service.BallCountService;
import baseball.service.RestartService;
import baseball.view.BallCountView;
import baseball.view.RestartView;

import java.util.Scanner;

public class AppContext {
	private final Scanner scanner;
	private final AppConfig appConfig;
	private final BallCountService ballCountService;
	private final RestartService restartService;
	private final BallCountView ballCountView;
	private final RestartView restartView;
	private final GameController gameController;

	private AppContext() {
		scanner = new Scanner(System.in);
		appConfig = new AppConfig();
		ballCountService = new BallCountService(appConfig);
		restartService = new RestartService(appConfig);
		ballCountView = new BallCountView(scanner);
		restartView = new RestartView(appConfig, scanner);
		gameController = new GameController(ballCountService, restartService, ballCountView, restartView);
	}

	private static class Holder {
		private static final AppContext INSTANCE = new AppContext();
	}

	public static AppContext getInstance() {
		return Holder.INSTANCE;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public AppConfig getAppConfig() {
		return appConfig;
	}

	public BallCountService getBallCountService() {
		return ballCountService;
	}

	public RestartService getRestartService() {
		return restartService;
	}

	public BallCountView getBallCountView() {
		return ballCountView;
	}

	public RestartView getRestartView() {
		return restartView;
	}

	public GameController getGameController() {
		return gameController;
	}
}
