package domain.game;

import constant.GameRule;
import domain.target.Balls;

public class GameMaster {
	private Game game;

	public Game startNewGame() {
		this.game = new Game();
		return game;
	}

	public TurnResult playTurn(Balls input) {
		Turn turn = game.playTurn(input);
		if (turn.getStrikeCount() == GameRule.BALL_COUNT) {
			game.clear();
		}
		return new TurnResult(turn.getBallCount(), turn.getStrikeCount());
	}

}
