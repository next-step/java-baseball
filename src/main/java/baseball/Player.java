package baseball;

import java.util.List;

public class Player {

	private Deck deck;

	public Player(Deck deck) {
		this.deck = deck;
	}

	public Deck getDeck() {
		return this.deck;
	}

	public List<Integer> numbers() {
		return deck.numbers();
	}

	@Override
	public String toString() {
		return this.numbers().toString();
	}

}
