package baseball.controller;

import baseball.service.BallCountService;
import baseball.service.RestartService;
import baseball.view.BallCountView;
import baseball.view.RestartView;

public class GameController {

	private final BallCountService ballCountService;
	private final RestartService restartService;
	private final BallCountView ballCountView;
	private final RestartView restartView;

	public GameController(BallCountService ballCountService, RestartService restartService,
	                      BallCountView ballCountView, RestartView restartView) {
		this.ballCountService = ballCountService;
		this.restartService = restartService;
		this.ballCountView = ballCountView;
		this.restartView = restartView;
	}

}
