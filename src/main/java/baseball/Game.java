package baseball;

import java.util.List;
import java.util.Scanner;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class Game {
	private static final String MESSAGE_ENTER_NUMBERS = "숫자를 입력해주세요 : ";
	private static final String MESSAGE_GOT_A_RIGHT_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String MESSAGE_ENTER_NEXT_STEP = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private Printer printer;
	private Scanner scanner;
	private boolean isEnd;
	private NextStepType nextStepType;

	Game() {
		this.printer = new Printer();
		this.scanner = new Scanner(System.in);
		this.isEnd = false;
		this.nextStepType = null;
	}

	NextStepType start() {
		List<Integer> computerNumbers = RandomNumberGenerator.generate();
		while (!isEnd) {
			printer.print(MESSAGE_ENTER_NUMBERS);
			List<Integer> myNumbers = waitAndGetNumberInput();
			GuessResult result = Guesser.guess(computerNumbers, myNumbers);
			printer.print(result.getMessage());
			endGameOnGuessRight(result);
		}
		return nextStepType;
	}

	private List<Integer> waitAndGetNumberInput() {
		String input = scanner.next();
		return NumberInputConverter.convert(input);
	}

	private void endGameOnGuessRight(GuessResult result) {
		if (result.isRight()) {
			end();
		}
	}

	private void end() {
		printer.print(MESSAGE_GOT_A_RIGHT_ANSWER);
		printer.print(MESSAGE_ENTER_NEXT_STEP);
		isEnd = true;
		waitAndGetNextStepInput();
	}

	private void waitAndGetNextStepInput() {
		String input = scanner.next();
		nextStepType = NextStepInputConverter.convert(input);
	}
}
