import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {
	BaseBallGame baseBallGame;

	@BeforeEach
	void setUp() {
		baseBallGame = new BaseBallGame();
	}

	@Test
	public void makeNumberTest() {
		LinkedHashSet<String> numbers = baseBallGame.makeNumbers();
		assertThat(numbers.size() == 3).isTrue();

		for(String number : numbers){
			assertTrue(number.matches("[1-9]"));
			System.out.println(number);
		}
	}
}
