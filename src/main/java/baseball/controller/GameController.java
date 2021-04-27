package baseball.controller;

import baseball.domain.BallCount;
import baseball.error.DuplicateCharactersException;
import baseball.error.NonRestartCharactersException;
import baseball.service.BallCountService;
import baseball.service.RestartService;
import baseball.view.BallCountView;
import baseball.view.RestartView;

import java.util.List;

public class GameController {
	private final BallCountService ballCountService;
	private final RestartService restartService;
	private final BallCountView ballCountView;
	private final RestartView restartView;

	public GameController(BallCountService ballCountService, RestartService restartService, BallCountView ballCountView, RestartView restartView) {
		this.ballCountService = ballCountService;
		this.restartService = restartService;
		this.ballCountView = ballCountView;
		this.restartView = restartView;
	}

	public void start() {
		matchBallCount(ballCountService.generateNumbers());
		if (!isRestart()) {
			return;
		}
		start();
	}

	private void matchBallCount(List<Integer> generateNumbers) {
		List<Integer> parseNumbers = requestRandomNumbers();
		BallCount ballCount = ballCountService.compareNumbers(generateNumbers, parseNumbers);
		ballCountView.responseBallCount(ballCount);
		if (generateNumbers.size() == ballCount.getStrike()) {
			return;
		}
		matchBallCount(generateNumbers);
	}

	private List<Integer> requestRandomNumbers() {
		try {
			String input = ballCountView.requestRandomNumbers();
			return ballCountService.parseNumbers(input);
		} catch (DuplicateCharactersException dce) {
			ballCountView.responseDuplicateCharacters();
		} catch (Exception e) {
			ballCountView.responseNonNumericCharacters();
		}
		return requestRandomNumbers();
	}

	private boolean isRestart() {
		try {
			String input = restartView.requestRestartCommand();
			return restartService.isRestart(input);
		} catch (NonRestartCharactersException e) {
			restartView.responseNonRestartCharacters();
		}
		return isRestart();
	}
}
