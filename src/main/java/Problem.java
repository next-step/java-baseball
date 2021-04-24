public class Problem {
	private String answer;

	public Problem() {
		initNumber();
	}

	public Problem(String answer) {
		this.answer = answer;
	}

	public void initNumber() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			int randomNumber = (int)(Math.random() * 9 + 1);
			builder.append(randomNumber);
		}

		this.answer = builder.toString();
	}

	private Result getResult(String input, int index) {
		if (answer.charAt(index) == input.charAt(index)) {
			return Result.STRIKE;
		}

		if (answer.contains(String.valueOf(input.charAt(index)))) {
			return Result.BALL;
		}

		return Result.NONE;
	}
}
