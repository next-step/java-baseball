package umpire;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class UmpireTest {

	private Umpire umpire;

	@BeforeEach
	void setUp() {
		List<Integer> targetNumber = Arrays.asList(7, 1, 3);
		umpire = new Umpire(targetNumber);
	}

	@ParameterizedTest
	@DisplayName("사용자입력의 스크라이크 수 테스트")
	@MethodSource("setStrikeTestData")
	public void checkStrike(List<Integer> input, int expected) {
		assertThat(umpire.checkStrike(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("심판의 check 로직 테스트")
	@MethodSource("setFullTestData")
	public void checkBall(List<Integer> input, Boolean expected) {
		assertThat(umpire.check(input)).isEqualTo(expected);
	}

	private static Object[] setStrikeTestData() {
		return new Object[] {
			new Object[] {Arrays.asList(1, 2, 3), 1},
			new Object[] {Arrays.asList(1, 4, 5), 0},
			new Object[] {Arrays.asList(6, 7, 1), 0},
			new Object[] {Arrays.asList(7, 1, 3), 3}
		};
	}

	private static Object[] setFullTestData() {
		return new Object[] {
			new Object[] {Arrays.asList(1, 2, 3), false},
			new Object[] {Arrays.asList(1, 4, 5), false},
			new Object[] {Arrays.asList(6, 7, 1), false},
			new Object[] {Arrays.asList(7, 1, 3), true}
		};
	}
}
