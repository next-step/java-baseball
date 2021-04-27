package machine;

import display.Display;

public class Machine {
	private final RandomGenerator randomGenerator;
	private int goalNumber;

	public Machine(RandomGenerator randomGenerator) {
		this.randomGenerator = randomGenerator;
		this.goalNumber = randomGenerator.generate();
	}

	public void question(Display display) {
		display.exposeQuestion();
	}

	public int getGoalNumber() {
		return goalNumber;
	}

	public void generateGoalNumber() {
		this.goalNumber = this.randomGenerator.generate();
	}
}
