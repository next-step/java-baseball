package game.baseball.domain.shared;

public enum ProcessStatus {
	RESTART(1), EXIT(2);

	private final int code;

	ProcessStatus(int code) {
		this.code = code;
	}

	private int getCode() {
		return code;
	}

	public static ProcessStatus valueOf(int code) {
		if (code == RESTART.getCode()) {
			return RESTART;
		}
		if (code == EXIT.getCode()) {
			return EXIT;
		}
		throw new IllegalArgumentException(Message.INPUT_WRONG_VALUE);
	}
}
