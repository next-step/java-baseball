public enum GameMenuEnum {
	RESTART(1),
	EXIT(2);

	public int number;

	GameMenuEnum(int number) {
		this.number = number;
	}

	public static boolean doesRestart(int selectedNumber) {
		return RESTART.number == selectedNumber;
	}
}
