package process;

import java.util.Scanner;

import engine.Ball1;
import engine.GameEngine;
import ui.InputOutputUtil;

public class GameManager {
	private static final int RESTART_GAME = 1;
	private static final int END_GAME = 2;
	private static final int ANSWER_LENGTH = 3;

	private GameEngine gameEngine;
	private InputOutputUtil inputOutputUtil;

	public GameManager(Scanner scanner) {
		this.gameEngine = new GameEngine(ANSWER_LENGTH);
		this.inputOutputUtil = new InputOutputUtil(scanner);
	}

	public void startGame() {
		while (!progressEachStage()) {
		}
		endGame();
	}

	public void endGame() {
		inputOutputUtil.endGame();
	}

	public boolean progressEachStage() {
		try {
			if (gameEngine.progressEachStage(new Ball1(inputOutputUtil.nextInput(), ANSWER_LENGTH))) {
				return true;
			}
			printCurrentStatus(gameEngine.getStrike(), gameEngine.getBall());
		} catch (Exception e) {
			inputOutputUtil.printError(e.getMessage());
		}
		return false;
	}

	public void printCurrentStatus(int strike, int ball) {
		inputOutputUtil.printStatus(strike, ball);
	}

}
