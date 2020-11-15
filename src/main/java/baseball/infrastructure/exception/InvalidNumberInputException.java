package baseball.infrastructure.exception;

import baseball.infrastructure.exception.InfraStructureException;

public class InvalidNumberInputException extends InfraStructureException {

	private final static String ERROR_MESSAGE = "잘못된 입력입니다. input : %c";
	public InvalidNumberInputException(char input) {
		super(String.format(ERROR_MESSAGE, input));
	}
}
