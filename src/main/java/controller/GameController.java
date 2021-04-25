package controller;

import domain.game.Game;
import domain.game.GameMaster;
import domain.game.RestartOrder;
import domain.game.TurnResult;
import domain.target.BallGenerator;
import domain.target.Balls;
import ui.Input;
import ui.Output;

public class GameController {
	private RestartOrder restartOrder = RestartOrder.RESTART;

	public void play() {
		Game game = GameMaster.startNewGame();
		do {
			playGame();
		} while (restartOrder != RestartOrder.EXIT);
	}

	private void playGame() {
		Game game = GameMaster.startNewGame();
		do {
			Output.showMessage(Output.REQUEST_INPUT_MESSAGE);
			Balls inputBalls = BallGenerator.generateBallsByNumber(Input.getClientRequest());
			TurnResult turnResult = GameMaster.playTurn(inputBalls, game);
			Output.showMessage(processTurnResult(turnResult, game));
		} while (!game.isCleared());
		Output.showMessage(Output.SUCCESS_MESSAGE);
		requestRestart();
	}

	private void requestRestart() {
		Output.showMessage(Output.REQUEST_RESTART_MESSAGE);
		restartOrder = RestartOrder.detect(Input.getClientRequest());
	}

	private String processTurnResult(TurnResult turnResult, Game game) {
		StringBuilder stringBuilder = new StringBuilder();
		if (turnResult.isNothing()) {
			return Output.NOTHING;
		}
		appendBallMessage(turnResult.getBallCount(), stringBuilder);
		appendStrikeMessage(turnResult.getStrikeCount(), stringBuilder);
		return stringBuilder.toString();
	}

	private void appendBallMessage(int ballCount, StringBuilder stringBuilder) {
		if (ballCount != 0) {
			stringBuilder.append(ballCount).append(Output.BALL);
		}
	}

	private void appendStrikeMessage(int strikeCount, StringBuilder stringBuilder) {
		if (strikeCount != 0) {
			stringBuilder.append(strikeCount).append(Output.STRIKE);
		}
	}
}
