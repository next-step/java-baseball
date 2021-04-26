package baseball;

import java.util.List;

import baseball.state.DecisionState;
import baseball.state.InningState;
import baseball.state.MenuState;
import baseball.state.State;

public class Game {

	private State menuState;
	private State inningState;
	private State decisionState;

	private State state;

	private Player player;
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

	public void createPlayer(List<Integer> deck) {
		this.player = new Player(Deck.createCustomDeck(deck));
	}

	public void createOpponent() {
		this.opponent = new Player(Deck.createRandomDeck());
	}

	public void onMenuState() {
		this.state = this.menuState;
	}

	public void onInningState() {
		this.state = this.inningState;
	}

	public void onDecisionState() {
		this.state = this.decisionState;
	}

	public State currentState() {
		return this.state;
	}

	public Player getPlayer() {
		return this.player;
	}

	public Player getOpponent() {
		return this.opponent;
	}

}
