package game.baseball.domain.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallNumberTest {
	@TestFactory
	@DisplayName("validateNull()에 의해 numbers가 null일때 실패한다")
	Collection<DynamicTest> validateNullTest() {
		return Arrays.asList(
			DynamicTest.dynamicTest("null일 경우 validateNull()에 의해 exception 발생,",
				() -> assertThatIllegalArgumentException()
					.isThrownBy(() -> new BaseBallNumber(null))
					.withMessage("숫자는 반드시 null이 아니어야 합니다.")),

			DynamicTest.dynamicTest("null이 아닐 경우 다른 validate에 의해 exception 발생",
				() -> assertThatIllegalArgumentException()
					.isThrownBy(() -> new BaseBallNumber(new ArrayList<>()))
					.withMessageNotContaining("숫자는 반드시 null이 아니어야 합니다."))
		);
	}

	@TestFactory
	@DisplayName("validateSize()에 의해 3자리 숫자일때만 생성되고 나머지의 경우에는 실패한다")
	Collection<DynamicTest> validateSizeTests() {
		List<DynamicTest> dynamicTests = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			List<Integer> numbers = new ArrayList<>();

			for (int j = 0; j < i; j++) {
				numbers.add(j + 1);
			}

			if (numbers.size() == 3) {
				dynamicTests.add(
					DynamicTest.dynamicTest("3자리 숫자일때 정상 동작",
						() -> assertThat(new BaseBallNumber(numbers))
							.isNotNull()
							.isInstanceOf(BaseBallNumber.class)
					)
				);
			} else {
				dynamicTests.add(
					DynamicTest.dynamicTest(numbers.size() + "자리 숫자일때 exception 발생",
						() -> assertThatIllegalArgumentException()
							.isThrownBy(() -> new BaseBallNumber(numbers))
							.withMessage("숫자는 3자리의 수 이어야 합니다.")
					)
				);
			}
		}

		return dynamicTests;
	}

	@TestFactory
	@DisplayName("validateDuplicate()에 의해 중복되는 숫자가 있을경우 exception 발생")
	Collection<DynamicTest> validateDuplicateTests() {
		return Arrays.asList(
			DynamicTest.dynamicTest("첫째자리 둘째자리 중복으로 exception 발생",
				() -> assertThatIllegalArgumentException()
					.isThrownBy(() -> new BaseBallNumber(Arrays.asList(1, 1, 2)))
					.withMessage("각 자리의 숫자들은 서로 다른 수 이어야 합니다.")
			),
			DynamicTest.dynamicTest("첫째자리 셋째자리 중복으로 exception 발생",
				() -> assertThatIllegalArgumentException()
					.isThrownBy(() -> new BaseBallNumber(Arrays.asList(1, 2, 1)))
					.withMessage("각 자리의 숫자들은 서로 다른 수 이어야 합니다.")
			),
			DynamicTest.dynamicTest("둘째자리 셋째자리 중복으로 exception 발생",
				() -> assertThatIllegalArgumentException()
					.isThrownBy(() -> new BaseBallNumber(Arrays.asList(2, 1, 1)))
					.withMessage("각 자리의 숫자들은 서로 다른 수 이어야 합니다.")
			),
			DynamicTest.dynamicTest("모두 중복으로 exception 발생",
				() -> assertThatIllegalArgumentException()
					.isThrownBy(() -> new BaseBallNumber(Arrays.asList(1, 1, 1)))
					.withMessage("각 자리의 숫자들은 서로 다른 수 이어야 합니다.")
			),
			DynamicTest.dynamicTest("모두 다른 수일때 생성",
				() -> assertThat(new BaseBallNumber(Arrays.asList(1, 2, 3)))
					.isNotNull()
					.isInstanceOf(BaseBallNumber.class)
			)
		);
	}

	@TestFactory
	@DisplayName("validateRange()에 의해 각 자리가 1~9 사이의 수가 아닐 경우 exception 발생")
	Collection<DynamicTest> validateRangeSingleTest() {
		List<DynamicTest> dynamicTests = new ArrayList<>();

		for (int i = 0; i < 15; i++) {
			List<Integer> numbers = new ArrayList<>();

			for (int j = i; j <= i + 2; j++) {
				numbers.add(j);
			}

			if (i >= 1 && i <= 9 - 2) {
				dynamicTests.add(
					DynamicTest.dynamicTest(String.format("%d, %d, %d 생성 성공", i, i + 1, i + 2),
						() -> assertThat(new BaseBallNumber(numbers))
							.isNotNull()
							.isInstanceOf(BaseBallNumber.class)
					)
				);
			} else {
				dynamicTests.add(
					DynamicTest.dynamicTest(String.format("%d, %d, %d exception 발생", i, i + 1, i + 2),
						() -> assertThatIllegalArgumentException()
							.isThrownBy(() -> new BaseBallNumber(numbers))
							.withMessage("각 자리의 숫자들은 1부터 9까지 수 이어야 합니다.")
					)
				);
			}
		}

		return dynamicTests;
	}

	@ParameterizedTest
	@CsvSource({"4,5,9", "6,2,1"})
	void getTest(int first, int second, int third) {
		BaseBallNumber baseBallNumber = new BaseBallNumber(Arrays.asList(first, second, third));

		assertThat(baseBallNumber.get(0)).isEqualTo(first);
		assertThat(baseBallNumber.get(1)).isEqualTo(second);
		assertThat(baseBallNumber.get(2)).isEqualTo(third);
	}

	@ParameterizedTest
	@CsvSource({"4,5,9", "6,2,1"})
	void getNumberTest(int first, int second, int third) {
		BaseBallNumber baseBallNumber = new BaseBallNumber(Arrays.asList(first, second, third));

		assertThat(baseBallNumber.getNumber()).isEqualTo(first * 100 + second * 10 + third);
	}
}
