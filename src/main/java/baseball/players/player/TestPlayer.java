package baseball.players.player;

import static baseball.players.player.Player.RestartCommand.*;
import static baseball.utils.DataConvertUtils.*;

import java.util.List;

import baseball.validator.NumberValidator;

public class TestPlayer implements Player {
	private final List<Integer> requestNumbers;
	private String requestNumber;
	private NumberValidator numberValidator = new NumberValidator();

	public TestPlayer(String strRequestNumbers) {
		numberValidator.validate(strRequestNumbers);

		this.requestNumbers = convertToIntegerArrays(strRequestNumbers);
	}

	public List<Integer> getRequestNumbers() {
		return requestNumbers;
	}

	public boolean isContinue() {
		return CONTINUE.getCode().equals(requestNumber);
	}

	public void setContinue(String requestNumber) {
		this.requestNumber = requestNumber;
	}
}
