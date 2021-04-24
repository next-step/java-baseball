package baseball.ui;

import java.util.Scanner;

import baseball.common.PrintMessage;
import baseball.domain.BallNumber;
import baseball.domain.BaseballResult;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.enums.GameState;
import baseball.service.BaseballRule;

public class BaseballGame {

	private final static int RESTART = 1;
	private final static int EXIT = 2;
	private static GameState gameState;
	private static Computer computer;
	private static Player player;
	private static BaseballRule baseballRule;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		initGame();
		while(gameState != GameState.GAME_END) {
			//System.out.println(computer.getBallNumber().toString());
			inputPlayerNumber();
			printHint();
			checkWin();
		}
	}

	private static void initGame() {
		gameState = GameState.GAME_START;
		System.out.println(PrintMessage.GAME_START_MESSAGE);
		computer = new Computer();
		player = new Player();
	}

	private static void inputPlayerNumber() {
		System.out.println(PrintMessage.INPUT_NUMBER_MESSAGE);
		int playerBallNumber = scanner.nextInt();
		player.setBallNumber(new BallNumber(playerBallNumber));
	}

	private static void checkWin() {
		BaseballResult baseballResult = baseballRule.getResult();
		if (baseballResult.getStrikeCount() == BallNumber.MAX_SIZE) {
			System.out.println(PrintMessage.WIN_MESSAGE);
			gameState = GameState.GAME_END;
			endGame();
		}
	}

	private static void printHint() {
		baseballRule = new BaseballRule(player.getBallNumber(), computer.getBallNumber());
		BaseballResult baseballResult = baseballRule.getResult();
		if (baseballResult.getStrikeCount() > BallNumber.MIN_SIZE)
			System.out.println(baseballResult.getStrikeCount() + " " + PrintMessage.HINT_STRIKE_MESSAGE);
		if (baseballResult.getBallCount() > BallNumber.MIN_SIZE)
			System.out.println(baseballResult.getBallCount() + " " + PrintMessage.HINT_BALL_MESSAGE);
		if (baseballResult.getStrikeCount() == BallNumber.MIN_SIZE && baseballResult.getBallCount() == BallNumber.MIN_SIZE)
			System.out.println(PrintMessage.HINT_NOTHING);
	}

	private static void endGame(){
		System.out.println(PrintMessage.GAME_END_MESSAGE);
		int end = scanner.nextInt();
		if(end == RESTART)
			initGame();
		if(end == EXIT)
			gameState = GameState.GAME_END;
	}
}
