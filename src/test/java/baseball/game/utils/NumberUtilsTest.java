package baseball.game.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {
	private List<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
	}

	@Test
	@RepeatedTest(100)
	@DisplayName("생성한 임의의 숫자 값은 범위 안에서 생성되는가")
	void getGeneratedRandomNumbers() {
		int number = NumberUtils.getGeneratedRandomNumber(1, 9);
		assertEquals(number > 0 && number < 10, true);
	}

	@Test
	@DisplayName("중복된 숫자는 없는지 확인")
	void selectNumbersNotDuplicate() {
		assertThat(NumberUtils.selectNumbersNotDuplicate(numbers, 2).size()).isEqualTo(2);
		assertThat(NumberUtils.selectNumbersNotDuplicate(numbers, 3).size()).isEqualTo(3);
	}

}