public class Problem {
	private String answer;

	public Problem() {
		initNumber();
	}

	public void initNumber() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			int randomNumber = (int)(Math.random() * 9 + 1);
			builder.append(randomNumber);
		}

		this.answer = builder.toString();
	}
}
