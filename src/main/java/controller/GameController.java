package controller;

import constant.GameMessage;
import domain.game.Game;
import domain.game.GameMaster;
import domain.game.RestartFlag;
import domain.game.TurnResult;
import domain.target.BallGenerator;
import domain.target.Balls;
import ui.Input;
import ui.Output;

public class GameController {
	private RestartFlag restartFlag;
	private GameMaster gameMaster;

	public void play() {
		gameMaster = new GameMaster();
		do {
			playGame();
		} while (restartFlag != RestartFlag.EXIT);
	}

	private void playGame() {
		Game game = gameMaster.startNewGame();
		do {
			Output.showMessage(GameMessage.REQUEST_INPUT_MESSAGE);
			Balls inputBalls = BallGenerator.generateBallsByNumber(Input.getClientRequest());
			TurnResult turnResult = gameMaster.playTurn(inputBalls);
			Output.showMessage(processTurnResult(turnResult));
		} while (!game.isCleared());
		Output.showMessage(GameMessage.SUCCESS_MESSAGE);
		requestRestart();
	}

	private void requestRestart() {
		Output.showMessage(GameMessage.REQUEST_RESTART_MESSAGE);
		restartFlag = RestartFlag.detect(Input.getClientRequest());
	}

	private String processTurnResult(TurnResult turnResult) {
		StringBuilder stringBuilder = new StringBuilder();
		if (turnResult.isNothing()) {
			return GameMessage.NOTHING;
		}
		appendBallMessage(turnResult.getBallCount(), stringBuilder);
		appendStrikeMessage(turnResult.getStrikeCount(), stringBuilder);
		return stringBuilder.toString();
	}

	private void appendBallMessage(int ballCount, StringBuilder stringBuilder) {
		if (ballCount != 0) {
			stringBuilder.append(ballCount).append(GameMessage.BALL);
		}
	}

	private void appendStrikeMessage(int strikeCount, StringBuilder stringBuilder) {
		if (strikeCount != 0) {
			stringBuilder.append(strikeCount).append(GameMessage.STRIKE);
		}
	}
}
