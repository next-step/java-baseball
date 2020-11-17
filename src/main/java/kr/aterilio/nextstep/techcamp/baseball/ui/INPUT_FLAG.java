package kr.aterilio.nextstep.techcamp.baseball.ui;

public enum INPUT_FLAG {

	NEW_GAME("1"),
	EXIT_GAME("2");

	private final String flag;

	private INPUT_FLAG(String flag) {
		this.flag = flag;
	}

	public boolean isEqual(String flag) {
		return this.flag.equals(flag);
	}
}
