import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import service.GameService;

public class GameServiceTest {

	private GameService gameService;

	@BeforeEach
	public void setUp() {
		gameService = new GameService();
	}

	@Test
	@DisplayName("생성된 3개의 숫자의 범위가 1~9인지 테스트")
	public void isContain_shouldReturnTrueValidRange() {
		Set<Integer> numbers = Sets.newHashSet(gameService.generate());
		for(int i : numbers) {
			assertThat(i > 0 && i < 10).isTrue();
		}
	}

	@Test
	@DisplayName("생성된 3개의 숫자가 서로 다른 숫자인지 테스트")
	public void isSize3_shouldReturnTrueDifferentThreeNumbers() {
		Set<Integer> numbers = Sets.newHashSet(gameService.generate());
		assertThat(numbers.size() == 3).isTrue();
	}
}
