package baseball.state;

import baseball.Game;
import baseball.Referee;
import baseball.io.Display;

public class DecisionState implements State {

	private Game game;

	public DecisionState(Game game) {
		this.game = game;
	}

	@Override
	public boolean action() {
		int strikes = Referee.countStrikes(game.getPlayer().getDeck(), game.getOpponent().getDeck());
		int balls = Referee.countBalls(game.getPlayer().getDeck(), game.getOpponent().getDeck());

		Display.count(strikes, balls);
		isAnswer(strikes);
		isNothing(strikes, balls);
		return true;
	}

	public void isAnswer(int strikes) {
		game.onInningState();
		if (Referee.isAnswer(strikes)) {
			game.onMenuState();
			Display.correct();
		}
	}

	private void isNothing(int strikes, int balls) {
		if (Referee.isNothing(strikes, balls)) {
			Display.nothing();
		}
	}

}
