/**
* FileName : BaseballNumberServiceImplTest.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball number service 구현체 test
*/
package baseball.core;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.BaseballNumber;

class BaseballNumberServiceImplTest {

	private BaseballNumberServiceImpl target;

	@BeforeEach
	void setUp() {
		this.target = new BaseballNumberServiceImpl();
	}

	@Test
	@DisplayName("Baseball random number 객체를 생성하는지 확인합니다.")
	void testRandomBaseballNumberNotNull() {
		BaseballNumber randomBaseballNumber = this.target.getRandomBaseballNumber();
		Assertions.assertThat(randomBaseballNumber).isNotNull();
	}

	@Test
	@DisplayName("Baseball random number가 1부터 9까지의 서로다른 수인지 확인합니다.")
	void testRandomBaseballNumberDifferent() {
		BaseballNumber randomBaseballNumber = this.target.getRandomBaseballNumber();

		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			numbers.add(i);
		}

		int first = randomBaseballNumber.getFirstNumber();
		int second = randomBaseballNumber.getSecondNumber();
		int third = randomBaseballNumber.getThirdNumber();

		Assertions.assertThat(numbers.contains(first)).isTrue();
		Assertions.assertThat(numbers.contains(second)).isTrue();
		Assertions.assertThat(numbers.contains(third)).isTrue();

		Assertions.assertThat(first == second).isFalse();
		Assertions.assertThat(second == third).isFalse();
		Assertions.assertThat(first == third).isFalse();
	}
}
