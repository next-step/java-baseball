package kr.aterilio.nextstep.techcamp.baseball.ui;

public enum INPUT_FLAG {

	NEW_GAME(1),
	EXIT_GAME(2);

	private final int flag;

	private INPUT_FLAG(int flag) {
		this.flag = flag;
	}

	public boolean isEqual(int flag) {
		return this.flag == flag;
	}
}
