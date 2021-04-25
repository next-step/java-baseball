package baseball;

import baseball.state.DecisionState;
import baseball.state.InningState;
import baseball.state.MenuState;
import baseball.state.State;

public class Game {

	private State menuState;
	private State inningState;
	private State decisionState;

	private State state;

	private Player player = new Player();
	private Player opponent;

	public Game() {
		menuState = new MenuState(this);
		inningState = new InningState(this);
		decisionState = new DecisionState(this);

		state = menuState;
	}

	public boolean action() {
		return state.action();
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}

	public State getState() {
		return this.state;
	}

	public State getMenuState() {
		return this.menuState;
	}

	public State getInningState() {
		return this.inningState;
	}

	public State getDecisionState() {
		return this.decisionState;
	}

	public Player getPlayer() {
		return this.player;
	}

	public Player getOpponent() {
		return this.opponent;
	}

}
