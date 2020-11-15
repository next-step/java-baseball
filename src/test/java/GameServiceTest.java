import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import constant.GameConstant;
import exception.BaseballGameException;
import service.GameService;

public class GameServiceTest implements GameConstant {

	private GameService gameService;

	@BeforeEach
	public void setUp() {
		gameService = new GameService();
	}

	@Test
	@DisplayName("생성된 3개의 숫자의 범위가 1~9인지 테스트")
	public void isContain_shouldReturnTrueValidRange() {
		Set<Integer> numbers = Sets.newHashSet(gameService.generate());
		for (int i : numbers) {
			assertThat(i > 0 && i < 10).isTrue();
		}
	}

	@Test
	@DisplayName("생성된 3개의 숫자가 서로 다른 숫자인지 테스트")
	public void isSize3_shouldReturnTrueDifferentThreeNumbers() {
		Set<Integer> numbers = Sets.newHashSet(gameService.generate());
		assertThat(numbers.size() == 3).isTrue();
	}

	@ParameterizedTest
	@DisplayName("사용자로부터 입력받은 값이 유효한 값인 경우 테스트")
	@ValueSource(strings = {"123", "879"})
	public void isTrue_shouldReturnTrueValidInput(String input) {
		assertTrue(gameService.getRefineInput(input).equals(input));
	}

	@ParameterizedTest
	@DisplayName("사용자로부터 입력받은 값이 유효하지 않은 경우 테스트")
	@ValueSource(ints = {3, 100})
	public void throwException_shouldThrowExceptionInValidInput(int input) {
		assertThatThrownBy(() -> {
			throw new BaseballGameException(BAD_INPUT);
		}).isInstanceOf(BaseballGameException.class)
			.hasMessageContaining(BAD_INPUT);
	}

	@ParameterizedTest
	@DisplayName("종료 시, 입력받은 값이 유효한 값인 경우 테스트")
	@ValueSource(ints = {1, 2})
	public void isTrue_shouldReturnTrueValidExitInput(int input) {
		assertTrue(gameService.isValidExitInput(input));
	}

	@ParameterizedTest
	@DisplayName("종료 시, 입력받은 값이 유효하지 않은 경우 테스트")
	@ValueSource(ints = {3, 100})
	public void isFalse_shouldReturnFalseInValidExitInput(int input) {
		assertFalse(gameService.isValidExitInput(input));
	}

	@ParameterizedTest
	@DisplayName("스트라이크 개수 테스트")
	@ValueSource(strings = {"178", "725", "123"})
	public void isTrue_shouldReturnMoreThanOneStrike(String input) {
		List<Integer> balls = Arrays.asList(1,2,3);
		assertThat(gameService.getStrikeCount(balls, input) > 0).isTrue();
	}

	@ParameterizedTest
	@DisplayName("볼 개수 테스트")
	@ValueSource(strings = {"239", "132", "287"})
	public void isFalse_shouldReturnFalseInValidExitInput(String input) {
		List<Integer> balls = Arrays.asList(7,2,8);
		assertThat(gameService.getBallCount(balls, input) > 0).isTrue();
	}
}
