package machine;

import display.Display;

public class Machine {
	private final int goalNumber;

	public Machine(int goalNumber) {
		this.goalNumber = goalNumber;
	}

	public void makeQuestion(Display display) {
		display.expose("숫자를 입력해주세요 : ");
	}

	public int getGoalNumber() {
		return goalNumber;
	}
}
