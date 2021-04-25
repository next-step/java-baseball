package baseball.state;

import java.util.Scanner;

import baseball.Deck;
import baseball.Game;
import baseball.Player;

public class MenuState implements State {

	private Scanner scanner = new Scanner(System.in);
	private Game game;

	public MenuState(Game game) {
		this.game = game;
	}

	@Override
	public boolean action() {
		if (shallWePlayTheGame()) {
			start();
			hint();
			return true;
		}
		return false;
	}

	public void start() {
		setOpponent();
		game.setState(game.getInningState());
	}

	public void setOpponent() {
		Deck deck = new Deck();
		Player opponent = new Player(deck.draw());
		game.setOpponent(opponent);
	}

	private boolean shallWePlayTheGame() {
		System.out.println("\n새 게임을 시작하겠습니까? (Y/n):");
		String select = scanner.nextLine();
		return !select.equals("n");
	}

	private void hint() {
		System.out.printf("힌트: %s\n", game.getOpponent());
	}
}
