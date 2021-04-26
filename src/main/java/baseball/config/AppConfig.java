package baseball.config;

public class AppConfig {
	private final int randomNumberLength = 3;
	private final int minRandomNumber = 1;
	private final int maxRandomNumber = 9;
	private final String restartCommand = "1";
	private final String exitCommand = "2";

	public int getRandomNumberLength() {
		return randomNumberLength;
	}

	public int getMinRandomNumber() {
		return minRandomNumber;
	}

	public int getMaxRandomNumber() {
		return maxRandomNumber;
	}

	public String getRestartCommand() {
		return restartCommand;
	}

	public String getExitCommand() {
		return exitCommand;
	}
}