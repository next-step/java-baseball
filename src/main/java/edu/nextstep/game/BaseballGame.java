package edu.nextstep.game;

public class BaseballGame {
	private final int SELECTED_NUMBER_SIZE = 3;
	private BaseballGamer player;
	private BaseballGamer computer;

	public void setPlayer(BaseballGamer player) {
		this.player = player;
	}

	public void resetComputer() {
		computer = BaseballGamer.generateComputer(SELECTED_NUMBER_SIZE);
	}

	public BaseballGamer getComputer() {
		return computer;
	}
}