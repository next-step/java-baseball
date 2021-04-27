package process;

import java.util.Scanner;

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

}
