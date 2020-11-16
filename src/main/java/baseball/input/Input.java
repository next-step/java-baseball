package baseball.input;

import baseball.Operation;
import baseball.game.Balls;

public interface Input {

	Operation getOperation();

	Balls getBalls();

	default <T> T get(InputCallback<T> callback, InputFailureCallback failureCallback) {
		while (true) {
			try {
				return callback.invoke();
			} catch (InputFailureException e) {
				failureCallback.invoke(e);
			}
		}
	}
}
