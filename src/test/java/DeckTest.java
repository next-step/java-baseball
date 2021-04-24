import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DeckTest {

	@Test
	void threeDigits() {
		Deck deck = new Deck();
		int[] numbers = deck.draw();
		assertThat(numbers).hasSize(3);
	}

}
