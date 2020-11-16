package edu.nextstep.game;

public class BaseballGame {
	private final int SELECTED_NUMBER_SIZE = 3;
	private BaseballGamer player;
	private BaseballGamer computer;
	private BaseballScore score;

	public void setPlayer(BaseballGamer player) {
		this.player = player;
	}

	public void resetComputer() {
		computer = BaseballGamer.generateComputer(SELECTED_NUMBER_SIZE);
	}

	public BaseballGamer getComputer() {
		return computer;
	}

	public void resetScore() {
		score = new BaseballScore(SELECTED_NUMBER_SIZE);
	}

	public BaseballScore playToEnd() {
		for (int index = 0; index < SELECTED_NUMBER_SIZE; index++) {
			updateScore(score, index, player, computer);
		}
		return score;
	}

	private void updateScore(BaseballScore score, int index, BaseballGamer player, BaseballGamer opponent) {
		String playerDigit = player.pickDigit(index);
		String opponentDigit = opponent.pickDigit(index);
		if (opponentDigit.equals(playerDigit)) {
			score.addStrike();
			return;
		}
		if (opponent.getSelectedNumber().contains(playerDigit)) {
			score.addBall();
		}
	}

	public boolean didWin() {
		return score.isEnd();
	}

	public int getSelectedNumberSize() {
		return SELECTED_NUMBER_SIZE;
	}

}