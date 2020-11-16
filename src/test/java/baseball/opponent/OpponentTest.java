package baseball.opponent;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OpponentTest {
	private Opponent opponent;

	@BeforeEach
	void setup() {
		opponent = new Computer();
	}

	@Test
	@DisplayName("1~9까지 서로 다른 3자리수 확인")
	void getHiddenNumber() {
		List<Integer> hiddenNumbers = opponent.getHiddenNumbers();
		Set<Integer> uniqueNumbers = new HashSet<>(hiddenNumbers);

		assertThat(uniqueNumbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("히든 숫자 초기화")
	void reset() {
		List<Integer> hiddenNumbers = opponent.getHiddenNumbers();
		opponent.reset();
		List<Integer> resetHiddenNumbers = opponent.getHiddenNumbers();

		assertThat(hiddenNumbers).isNotEqualTo(resetHiddenNumbers);
	}
}
