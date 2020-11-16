package com.coderhglee.game.baseball;

import java.util.Scanner;

import com.coderhglee.game.GameCommand;
import com.coderhglee.game.GameSettingProperties;
import com.coderhglee.game.exception.GameException;
import com.coderhglee.game.exception.NotAllowValueException;
import com.coderhglee.game.number.UserInputNumber;


public class BaseballGameUI {

	private static GameCommand statusCommand = GameCommand.RESTART_GAME_VALUE;
	private static final Scanner scanner = new Scanner(System.in);

	private BaseballGameUI() {

	}

	public static void executeGame() throws GameException {
		if (!statusCommand.equals(GameCommand.END_GAME_VALUE)) {
			BaseballGame baseballGame = new BaseballGame();
			executeBaseballGame(baseballGame);
		}
		System.exit(statusCommand.value);
	}

	private static void executeBaseballGame(BaseballGame game) {
		try {
			executeGameRound(game);
		} catch (GameException gameException) {
			System.out.println(gameException.getMessage());
			executeBaseballGame(game);
		}
	}

	private static void executeGameRound(BaseballGame game) throws GameException {
		while (!game.getGameStatus().equals(BaseballGameStatus.WIN)) {
			System.out.print(GameSettingProperties.ROUND_START_MESSAGE.message);
			game.gameProcess(new UserInputNumber(scanner.nextLine()));
			System.out.println(game.getGameResultMessage());
		}
		endAllGameRound();
	}

	private static void endAllGameRound() throws GameException {
		System.out.println(GameSettingProperties.GAME_START_MESSAGE.message);
		findGameCommandFromMessage(scanner.nextLine());
	}

	private static GameCommand findGameCommandFromMessage(String inputMessage) throws GameException {
		for (GameCommand command : GameCommand.values()) {
			setCommandFromInputMessage(command, inputMessage);
		}
		throw new NotAllowValueException();
	}

	private static void setCommandFromInputMessage(GameCommand command, String inputMessage) throws GameException {
		String commandValue = String.valueOf(command.value);
		if (inputMessage.equals(commandValue)) {
			statusCommand = command;
			executeGame();
		}
	}
}
