package domain.game;

public enum RestartFlag {
	RESTART(1),
	EXIT(2);

	private int order;

	RestartFlag(int order) {
		this.order = order;
	}

	public static RestartFlag detect(int order) {
		if (order == RESTART.order) {
			return RESTART;
		} else if (order == EXIT.order) {
			return EXIT;
		}
		throw new IllegalArgumentException("1 이나 2 를 입력해주세요");
	}
}
