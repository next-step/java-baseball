package baseball.config;

public class AppConfig {
	private final int randomNumberLength;
	private final int minRandomNumber;
	private final int maxRandomNumber;
	private final String restartCommand;
	private final String exitCommand;

	public AppConfig(int randomNumberLength, int minRandomNumber, int maxRandomNumber, String restartCommand, String exitCommand) {
		this.randomNumberLength = randomNumberLength;
		this.minRandomNumber = minRandomNumber;
		this.maxRandomNumber = maxRandomNumber;
		this.restartCommand = restartCommand;
		this.exitCommand = exitCommand;
	}

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