package util;

public enum NumberBaseballGameCommand {
	CONTINUE(1), TERMINATE(2);

	private int code;

	NumberBaseballGameCommand(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	static public boolean isContinue(int code) {
		if (code == CONTINUE.code) {
			return true;
		}

		return false;
	}

	static public boolean isTerminate(int code) {
		if (code == TERMINATE.code) {
			return true;
		}

		return false;
	}

	static public boolean validateCommand(int code) {
		if (isContinue(code) || isTerminate(code)) {
			return true;
		}

		return false;
	}
}
