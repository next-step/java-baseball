package baseball.state;

import baseball.Game;
import baseball.Referee;

public class DecisionState implements State {

	private Referee referee = new Referee();
	private Game game;

	public DecisionState(Game game) {
		this.game = game;
	}

	@Override
	public boolean action() {
		int strikes = referee.countStrikes(game.getPlayer().getNumbers(), game.getOpponent().getNumbers());
		int balls = referee.countBall(game.getPlayer().getNumbers(), game.getOpponent().getNumbers());

		count(strikes, balls);
		isAnswer(strikes);
		isNothing(strikes, balls);

		return true;
	}

	public void isAnswer(int strikes) {
		game.setState(game.getInningState());

		if (referee.isAnswer(strikes)) {
			game.setState(game.getMenuState());
			correct();
		}
	}

	private void correct() {
		System.out.println("정답입니다!");
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

	private void isNothing(int strikes, int balls) {
		if (referee.isNothing(strikes, balls)) {
			System.out.println("낫싱");
		}
	}

}
