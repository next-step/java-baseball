package baseball;

public class BaseBallGame {
	public static final int RESTART_GAME = 1;
	public static final int END_GAME = 2;
	private Computer computer;

	public BaseBallGame() {
		this.computer = new Computer();
		this.computer.setNumber(Number.getRandomNumberWithoutDuplicate());
	}

	public int gameStart() {
		return -1;
	}
}
