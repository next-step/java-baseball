public class ExitOrRestartValidation implements InputNumberValidation {
	private static final int RESTART_GAME = 1;
	private static final int EXIT_GAME = 2;

	@Override
	public boolean validate(int inputNumber) {
		return !(inputNumber == RESTART_GAME || inputNumber == EXIT_GAME);
	}
}
