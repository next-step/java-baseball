package baseball.state;

import baseball.Game;
import baseball.Referee;

public class DecisionState implements State {

	private Game game;

	public DecisionState(Game game) {
		this.game = game;
	}

	@Override
	public boolean action() {
		int strikes = Referee.countStrikes(game.getPlayer().getDeck(), game.getOpponent().getDeck());
		int balls = Referee.countBalls(game.getPlayer().getDeck(), game.getOpponent().getDeck());

		count(strikes, balls);
		isAnswer(strikes);
		isNothing(strikes, balls);

		return true;
	}

	private void count(int strikes, int balls) {
		if (strikes > 0) {
			System.out.printf("%d 스트라이크 ", strikes);
		}
		if (balls > 0) {
			System.out.printf("%d 볼", balls);
		}
		if (strikes + balls > 0) {
			System.out.println();
		}
	}

	public void isAnswer(int strikes) {
		game.onInningState();
		if (Referee.isAnswer(strikes)) {
			game.onMenuState();
			correct();
		}
	}

	private void correct() {
		System.out.println("정답입니다!");
	}

	private void isNothing(int strikes, int balls) {
		if (Referee.isNothing(strikes, balls)) {
			System.out.println("낫싱");
		}
	}

}
