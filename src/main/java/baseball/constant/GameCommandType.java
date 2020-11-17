package baseball.constant;

import java.util.HashSet;

public enum GameCommandType {

	RETRY("1"),
	EXIT("2");

	private final String command;

	GameCommandType(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}

	public static boolean isExistType(String command) {
		GameCommandType[] gameCommandTypes = GameCommandType.values();

		HashSet<String> values = new HashSet<>();
		for (GameCommandType gameCommandType : gameCommandTypes) {
			values.add(gameCommandType.getCommand());
		}
		if (values.contains(command)) {
			return true;
		}
		return false;

	}

}
