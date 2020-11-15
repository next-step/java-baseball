package baseball.game;

import static baseball.constants.GameConstants.*;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.regex.Pattern;

import baseball.exception.DoNotPlayTheGameException;
import baseball.player.Computer;
import baseball.player.User;

public class Game {
	private static Game game = null;
	private GameStatus status = GameStatus.OFF;
	private User user;
	private Computer computer;
	private GameRule gameRule;

	private Game() {
		initialize();
	}

	public static Game onGame() {
		if (game == null) {
			game = new Game();
		}
		return game;
	}

	public User getUser() {
		return user;
	}

	public Computer getComputer() {
		return computer;
	}

	private void initialize() {
		status = GameStatus.PAUSE;
		computer = new Computer(generateRandomNumber());
		user = new User();
		gameRule = new GameRule(this);
	}

	private String generateRandomNumber() {
		SecureRandom random = new SecureRandom();
		HashMap<Integer, Integer> resultMap = new HashMap<>();
		for (int i = 0; i < ALLOW_PLAYER_NUMBER_MAX_LENGTH; i = resultMap.size()) {
			int value = random.nextInt(ALLOW_PLAYER_NUMBER_BOUND);
			resultMap.put(value, value);
		}
		return resultMap.values().toString().replaceAll("[^0-9]", "");
	}

	public void playGame() {
		if (status != GameStatus.PAUSE) {
			throw new DoNotPlayTheGameException();
		}
		status = GameStatus.ON;
		do {
			user.setNumber(input(MESSAGE_INPUT_USER_NUMBER, Pattern::matches, REGEX_ALLOW_PLAYER_INPUT));
		} while (!isPassedGame());
		selectReplayOrNot();
	}

	private String input(String message, BiPredicate<String, String> validation, String regex) {
		boolean isNotValid = true;
		String result = null;
		while (isNotValid) {
			result = receivePlayerInput(message);
			isNotValid = !validation.test(regex, result);
		}
		return result;
	}

	private String receivePlayerInput(String message) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(message);
		return scanner.next();
	}

	private boolean isPassedGame() {
		GameCount gameCount = gameRule.judgeGameCount();
		gameCount.displayGameCount();
		return gameCount.isPassed();
	}

	private void selectReplayOrNot() {
		status = GameStatus.PAUSE;
		String replaySign = input(String.format(MESSAGE_INPUT_USER_GAME_STATUS, GAME_STATUS_REPLAY, GAME_STATUS_STOP),
			Pattern::matches, REGEX_GAME_STATUS_INPUT);
		if (Integer.parseInt(replaySign) != GAME_STATUS_REPLAY) {
			status = GameStatus.OFF;
			return;
		}
		replayGame();
	}

	private void replayGame() {
		initialize();
		playGame();
	}
}
