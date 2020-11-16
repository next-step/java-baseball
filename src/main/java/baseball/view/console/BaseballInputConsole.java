package baseball.view.console;

import baseball.controller.dto.EndGameRequest;
import baseball.controller.dto.GuessNumberRequest;
import baseball.view.BaseballInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballInputConsole implements BaseballInput {

	private final Scanner scanner = new Scanner(System.in);

	private final String GUESS_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private final String GUESS_NUMBER_ERROR_MESSAGE = "잘못된 입력값. 다시 입력해주세요.";
	private final String END_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private final String END_GAME_ERROR_MESSAGE = "잘못된 입력값. 다시 입력해주세요.";
	private final int NUMBER_OF_GUESS_NUMBER = 3;
	private final int END_GAME_INPUT_LENGTH = 1;

	@Override
	public GuessNumberRequest getGuessNumberRequest() {
		String rawInput = getValidGuessNumber();
		return convertToGuessNumberRequest(rawInput);
	}

	private String getValidGuessNumber() {
		String rawInput;
		do {
			System.out.print(GUESS_NUMBER_MESSAGE);
			rawInput = scanner.nextLine();
		} while (!isValidGuessNumber(rawInput));
		return rawInput;
	}

	private boolean isValidGuessNumber(String rawInput) {
		if (!checkGuessNumberLength(rawInput)
				|| !Character.isDigit(rawInput.charAt(0))
				|| !Character.isDigit(rawInput.charAt(1))
				|| !Character.isDigit(rawInput.charAt(2))
		) {
			System.out.println(GUESS_NUMBER_ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean checkGuessNumberLength(String rawInput) {
		return rawInput.length() == NUMBER_OF_GUESS_NUMBER;
	}

	private GuessNumberRequest convertToGuessNumberRequest(String rawInput) {
		List<Integer> guessNumber = new ArrayList<>();
		for (int i = 0; i < NUMBER_OF_GUESS_NUMBER; i++) {
			guessNumber.add(rawInput.charAt(i) - '0');
		}
		return new GuessNumberRequest(guessNumber);
	}

	@Override
	public EndGameRequest getEndGameRequest() {
		String rawInput = getValidEndGameAction();
		return convertToEndGameRequest(rawInput);
	}

	private String getValidEndGameAction() {
		String rawInput;
		do {
			System.out.print(END_GAME_MESSAGE);
			rawInput = scanner.nextLine();
		} while (!isValidEndGameAction(rawInput));
		return rawInput;
	}

	private boolean isValidEndGameAction(String rawInput) {
		System.out.println(rawInput);
		if (rawInput.length() != END_GAME_INPUT_LENGTH
				|| (rawInput.charAt(0) != '1' && rawInput.charAt(0) != '2')
		) {
			System.out.println(END_GAME_ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private EndGameRequest convertToEndGameRequest(String rawInput) {
		if (rawInput.charAt(0) == '1') {
			return new EndGameRequest(EndGameRequest.Action.RESTART);
		} else if (rawInput.charAt(0) == '2') {
			return new EndGameRequest(EndGameRequest.Action.END);
		}
		return null;
	}
}
