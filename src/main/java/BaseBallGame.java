public class BaseBallGame {
	int computerPlayer = 0;
	int userPlayer = 0;

	/*
	 * 숫자야구게임 시작
	 * */
	public void start() {
		System.out.println("숫자야구게임 시작");
		computerPlayer = generateComputerPlayer();
	}

	private int generateComputerPlayer() {
		int computerNumber1 = 0;
		int computerNumber2 = 0;
		int computerNumber3 = 0;

		while (computerNumber1 == computerNumber2
				|| computerNumber1 == computerNumber3
				|| computerNumber2 == computerNumber3) {
			computerNumber1 = (int) (Math.random() * 9) + 1;
			computerNumber2 = (int) (Math.random() * 9) + 1;
			computerNumber3 = (int) (Math.random() * 9) + 1;
		}

		return (computerNumber1 * 100) + (computerNumber2 * 10) + computerNumber3;
	}
}
