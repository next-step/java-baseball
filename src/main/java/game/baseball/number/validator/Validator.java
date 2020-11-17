package game.baseball.number.validator;

public interface Validator<T> {

    boolean validate(T input);
}
