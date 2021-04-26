public class ThreeDigitValidation implements InputNumberValidation {
	private static final int MIN_QUESTION_NUMBER = 100;
	private static final int MAX_QUESTION_NUMBER = 999;

	@Override
	public boolean validate(int inputNumber) {
		return (MIN_QUESTION_NUMBER < inputNumber && inputNumber < MAX_QUESTION_NUMBER);
	}
}

