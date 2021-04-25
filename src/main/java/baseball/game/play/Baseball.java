package baseball.game.play;

/*
 * @(#) Baseball.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import baseball.game.config.BaseBallGameConfig;
import baseball.game.constants.BaseballResultType;
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

	GameStatusType type;

	public Baseball () {
		this.type = GameStatusType.START;
	}

	public void initialize() {
		generatedComputerNumbers();
	}

	public void initCount() {
		this.strikeCounts = 0;
		this.ballCounts = 0;
	}

	public void inputNumbers() {
		System.out.println(Message.INPUT_MESSAGE.getMessage());
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		if (!ValidationUtils.isValidNumber(input)) {
			throw new NumberFormatException();
		}

		if (!ValidationUtils.checkNumberLengh(input, BaseBallGameConfig.MAX_NUMBER_LENGTH)) {
			throw new NotAllowedLengthException();
		}

		checkNumbers(input);
		initCount();
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
	}

	public String getResultMessage() {
		String message;

		message = strikeCounts > 0 ? String.format("%d %s", strikeCounts, BaseballResultType.STRIKE.getValue()) : "";
		message += ballCounts > 0 ? String.format("%d %s", ballCounts, BaseballResultType.BALL.getValue()) : "";
		message += strikeCounts + ballCounts == 0 ? String.format("%s", BaseballResultType.NOTHING.getValue()) : "";

		return message;
	}

}
