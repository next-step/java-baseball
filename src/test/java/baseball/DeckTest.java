package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeckTest {

	List<Integer> digits = Deck.create();
	List<Integer> deck = Deck.draw();

	@DisplayName("무작위 덱 객체 생성")
	@Test
	void createRandomDeck() {
		Deck deck = Deck.createRandomDeck();
		assertThat(deck.numbers()).hasSize(Deck.SIZE);
	}

	@DisplayName("사용자 덱 객체 생성")
	@Test
	void createCustomDeck() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
		Deck deck = Deck.createCustomDeck(list);
		assertThat(deck.numbers()).hasSize(Deck.SIZE);
	}

	@DisplayName("생성한 숫자 목록 길이: 9")
	@Test
	void digitsSize() {
		assertThat(digits).hasSize(9);
	}

	@DisplayName("생성한 숫자 범위 확인: 1 ~ 9")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void create(int value) {
		assertThat(digits.contains(value)).isTrue();
	}

	@DisplayName("무작위 숫자 3개")
	@Test
	void customDraw() {
		assertThat(deck).hasSize(3);
	}

	@DisplayName("무작위 숫자 3개 범위: 1 ~ 9")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	void customDraw(int index) {
		assertThat(deck.get(index)).isBetween(1, 9);
	}


}
