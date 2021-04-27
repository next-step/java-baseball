package baseball.validator;

public interface InputValidator<T> {
	boolean isValid(T input);
}

