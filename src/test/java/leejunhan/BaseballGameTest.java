package leejunhan;

import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballGameTest {

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void main() {
	}

	@Test
	@DisplayName("야구게임 숫자 생성 - 중복된 숫자 없는지 체크")
	void getBaseballNumber() {
		BaseballGame.getBaseballNumber();
	}

	private static Stream<Arguments> numberArrayParameter() {
		return Stream.of(
			Arguments.of(new int[]{1,0}),
			Arguments.of(new int[]{5,6})
		);
	}

	@ParameterizedTest
	@MethodSource("numberArrayParameter")
	@DisplayName("숫자 중복되지 않게 생성되는지 체크")
	void getOneRandomNumber(int[] randomNumberArray) {
		int newRandomNumber = BaseballGame.getOneRandomNumber(randomNumberArray);
		for (int randomNumber : randomNumberArray) {
			assertThat(newRandomNumber).isNotEqualTo(randomNumber);
			System.out.println("randomNumber = " + randomNumber);
		}
		System.out.println("newRandomNumber = " + newRandomNumber);
	}

	@DisplayName("1~9 사이의 숫자로 생성되는지 체크")
	@RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}" )
	void getRandomNumberRangeOneToNine() {
		int randomNumber = BaseballGame.getRandomNumberRangeOneToNine();
		System.out.println("randomNumber = " + randomNumber);
		assertThat(randomNumber)
			.as("randomNumber=%d : randomNumber must be between 1 and 9.", randomNumber)
			.isGreaterThan(0).isLessThan(10);
	}

	@DisplayName("중복숫자 체크 - 기준숫자와 랜덤숫자가 동일함 (중복)")
	@ParameterizedTest
	@CsvSource({"1,1", "9,9"})
	void duplicateFlagTrueSuccess(int standardNumber, int randomNumber) {
		System.out.printf("standardNumber = %d, randomNumber = %d", standardNumber, randomNumber);
		assertThat(BaseballGame.duplicateFlag(standardNumber, randomNumber)).isTrue();
	}

	@DisplayName("중복숫자 체크 - 기준숫자와 랜덤숫자가 다름 (중복아님)")
	@ParameterizedTest
	@CsvSource({"1,2", "9,1"})
	void duplicateFlagFalseSuccess(int standardNumber, int randomNumber) {
		System.out.printf("standardNumber = %d, randomNumber = %d", standardNumber, randomNumber);
		assertThat(BaseballGame.duplicateFlag(standardNumber, randomNumber)).isFalse();
	}
}
