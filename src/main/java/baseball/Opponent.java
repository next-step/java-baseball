package baseball;

// TODO: Add Interface
public class Opponent {

	private int[] numbers;

	public Opponent() {
		Deck deck = new Deck();
		numbers = deck.draw();
	}

	public int[] getNumbers() {
		return numbers;
	}

}
