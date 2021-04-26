package baseball;

class Player {
	private int numberLength;

	Player(int numberLength) {
		this.numberLength = numberLength;
	}

	int[] guess(int input) {
		int[] guess = new int[numberLength];

		for (int i = numberLength - 1; i >= 0; i--, input /= 10) {
			guess[i] = input % 10;
		}

		return guess;
	}

	ProceedType proceed(int input) {
		if (input == 1)
			return ProceedType.RESTART;

		if (input == 2)
			return ProceedType.EXIT;

		return ProceedType.EXIT;
	}
}
