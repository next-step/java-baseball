package baseball.command;

import java.util.InputMismatchException;
import java.util.Scanner;

import baseball.InvalidOperationValueException;
import baseball.Operation;
import baseball.game.Balls;
import baseball.game.InvalidBallNumbersException;
import baseball.input.Input;
import baseball.input.InputFailureException;

public class ScannerInput implements Input {

	@Override
	public Operation getOperation() {
		try  {
			Scanner scanner = new Scanner(System.in);
			return Operation.of(scanner.nextInt());
		} catch (InputMismatchException e) {
			throw new InputFailureException();
		} catch (InvalidOperationValueException e) {
			throw new InputFailureException(e.getValue());
		}
	}

	@Override
	public Balls getBalls() {
		try {
			Scanner scanner = new Scanner(System.in);
			return new Balls(scanner.nextLine());
		} catch (InvalidBallNumbersException e) {
			throw new InputFailureException(e.getBallNumbers());
		}
	}
}
