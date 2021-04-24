package domain.game;

import domain.target.Balls;

public class GameMaster {

	public static Game startNewGame() {
		return new Game();
	}

	public static TurnResult playTurn(Balls input, Game game) {
		Turn turn = game.playTurn(input);
		return new TurnResult(turn.getBallCount(), turn.getStrikeCount());
	}
}
