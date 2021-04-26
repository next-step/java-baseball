package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerTest {

	List<Integer> origin = new ArrayList<>(Arrays.asList(1, 2, 3));
	Deck deck = Deck.createCustomDeck(origin);
	Player player = new Player(deck);
	List<Integer> numbers = player.numbers();

	@DisplayName("플레이어 선택 숫자 확인")
	@ParameterizedTest
	@CsvSource(value = {"0:1", "1:2", "2:3"}, delimiter = ':')
	void equalNumbers(int index, int expected) {
		assertThat(numbers.get(index)).isEqualTo(expected);
	}

	@DisplayName("사용자 숫자 출력")
	@Test
	void printString() {
		assertThat(player.toString()).isEqualTo(origin.toString());
	}
}
