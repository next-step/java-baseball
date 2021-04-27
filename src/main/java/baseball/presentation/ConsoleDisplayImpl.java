package baseball.presentation;

public class ConsoleDisplayImpl implements Display {
	@Override
	public void show(String message) {
		System.out.print(message);
	}
}
