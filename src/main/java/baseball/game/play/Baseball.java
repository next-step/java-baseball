package baseball.game.play;

/*
 * @(#) Baseball.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import baseball.game.config.BaseBallGameConfig;
import baseball.game.constants.BaseballResultType;
import baseball.game.constants.ErrorMessage;
import baseball.game.constants.GameStatusType;
import baseball.game.constants.Message;
import baseball.game.exception.NotAllowedLengthException;
import baseball.game.utils.NumberUtils;
import baseball.game.utils.ValidationUtils;

/**
 * @author 박준영
 **/
public class Baseball {

	private List<Integer> computerNumbers = new ArrayList<>();
	private int strikeCounts;
	private int ballCounts;

	GameStatusType gameStatusType;

	public Baseball () {
		this.gameStatusType = GameStatusType.START;
	}

	public Baseball (List<Integer> computerNumbers) {
		this.gameStatusType = GameStatusType.START;
		this.computerNumbers = computerNumbers;
	}

	public void initialize() {
		computerNumbers = new ArrayList<>();
		generatedComputerNumbers();
	}

	public void initCount() {
		this.strikeCounts = 0;
		this.ballCounts = 0;
	}

	public List<Integer> getComputerNumbers() {
		return computerNumbers;
	}

	public int getStrikeCounts() {
		return strikeCounts;
	}

	public int getBallCounts() {
		return ballCounts;
	}

	public void execute() {
		initCount();
		printMessage(getGameStatusMessage());

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		if (GameStatusType.PAUSE.equals(gameStatusType)) {
			if ("1".equals(input)) {
				gameStatusType = GameStatusType.START;
				initialize();
			} else if ("2".equals(input)) {
				gameStatusType = GameStatusType.STOP;
			}
		} else {
			validationCheck(input);
			checkNumbers(input);
			printMessage(getResultMessage());
		}
	}

	public void validationCheck(String input) {
		if (!ValidationUtils.isValidNumber(input)) {
			throw new NumberFormatException(ErrorMessage.NOT_INPUT_FORMAT.getMessage());
		}

		if (!ValidationUtils.checkNumberLengh(input, BaseBallGameConfig.MAX_NUMBER_LENGTH)) {
			throw new NotAllowedLengthException();
		}
	}

	public void generatedComputerNumbers() {
		while (computerNumbers.size() < BaseBallGameConfig.MAX_NUMBER_LENGTH) {
			int generatedNumber = NumberUtils.getGeneratedRandomNumber(BaseBallGameConfig.MIN_RANDOM_NUMBER, BaseBallGameConfig.MAX_RANDOM_NUMBER);
			computerNumbers = NumberUtils.selectNumbersNotDuplicate(computerNumbers, generatedNumber);
		}
	}

	public void checkNumbers(String input) {
		for (int i = 0; i < input.length(); i++) {
			int inputNumber = input.charAt(i) - '0';

			if (computerNumbers.get(i) == inputNumber) {
				strikeCounts++;
			} else if (computerNumbers.contains(inputNumber)) {
				ballCounts++;
			}
		}

		if (strikeCounts == BaseBallGameConfig.MAX_STRIKE_COUNT) {
			gameStatusType = GameStatusType.PAUSE;
		}
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	public String getGameStatusMessage() {
		String message = "";
		if (GameStatusType.PAUSE.equals(gameStatusType)) {
			message = Message.SUCCESS_MESSAGE.getMessage().replace("n", String.valueOf(strikeCounts)) + "\r\n";
			message += Message.CONTINUE_MESSAGE.getMessage();
		} else if (GameStatusType.START.equals(gameStatusType)) {
			message = Message.INPUT_MESSAGE.getMessage();
		}

		return message;
	}

	public String getResultMessage() {
		String message;
		message = strikeCounts > 0 ? String.format("%d %s", strikeCounts, BaseballResultType.STRIKE.getValue()) : "";
		message += ballCounts > 0 ? String.format("%d %s", ballCounts, BaseballResultType.BALL.getValue()) : "";
		message += strikeCounts + ballCounts == 0 ? String.format("%s", BaseballResultType.NOTHING.getValue()) : "";

		return message;
	}

}
