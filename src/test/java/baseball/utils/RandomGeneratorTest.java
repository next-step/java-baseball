package baseball.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Game;

public class RandomGeneratorTest {
	private static List<Integer> SelectedNumbers = new ArrayList<>();

	@BeforeAll
	@DisplayName("3자리 수 난수 생성")
	static void init() {
		RandomGenerator generator = new RandomGenerator();
		SelectedNumbers = generator.makeRandomNumbers();
	}

	@Test
	@DisplayName("3자리 수로 구성되어 있다.")
	public void isThreeDigits() {
		assertEquals(SelectedNumbers.size(), Game.NUMBER_LENGTH);
	}

	@Test
	@DisplayName("1~9 사이의 숫자로 구성되어 있다.")
	public void isAllDigitsBetweenOnetoNine() {
		for (int i = 0; i < Game.NUMBER_LENGTH; i++) {
			assertThat(SelectedNumbers.get(i)).isBetween(1, 9);
		}
	}

	@Test
	@DisplayName("서로 다른 3개의 수로 구성되어 있다.")
	public void isNotDuplicate() throws Exception {
		assertNotEquals(SelectedNumbers.get(0), SelectedNumbers.get(1));
		assertNotEquals(SelectedNumbers.get(1), SelectedNumbers.get(2));
		assertNotEquals(SelectedNumbers.get(2), SelectedNumbers.get(0));
	}
}
