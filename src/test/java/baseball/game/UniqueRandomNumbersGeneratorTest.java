package baseball.game;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UniqueRandomNumbersGeneratorTest {

	static int min = 1;
	static int max = 9;

	NumbersGenerator numbersGenerator;

	@BeforeEach
	void setUp() {
		List<Integer> allowedNumbers = new ArrayList<>();
		for (int i = min; i <= max; i++) {
			allowedNumbers.add(i);
		}

		this.numbersGenerator = new UniqueRandomNumbersGenerator(allowedNumbers);
	}

	@DisplayName("생성 가능한 숫자 목록 조회 테스트")
	@Test
	void getAllowedNumbers() {
		List<Integer> allowedNumbers = numbersGenerator.getNumberPool();
		assertThat(allowedNumbers).isNotNull();
		assertThat(allowedNumbers.size()).isEqualTo(this.max - this.min + 1);
	}

	@DisplayName("최대 생성 개수 조회 테스트")
	@Test
	void getLimitCount() {
		int limitCount = numbersGenerator.getLimitCount();

		assertThat(limitCount).isEqualTo(this.max - this.min + 1);
	}

	@DisplayName("유니크한 랜덤 넘버 생성 테스트")
	@ParameterizedTest
	@MethodSource("generate")
	void generate(int count) {
		List<Integer> numbers = numbersGenerator.generate(count);
		assertThat(numbers).isNotNull();
		assertThat(numbers.size()).isEqualTo(count);
		isAllowedNumbers(numbers);
		isUniqueNumbers(numbers);
	}

	private void isAllowedNumbers(List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			assertThat(numbers.get(i)).isIn(numbersGenerator.getNumberPool());
		}
	}

	private void isUniqueNumbers(List<Integer> numbers) {
		Set<Integer> numberSet = new HashSet<>(numbers);
		assertThat(numberSet.size()).isEqualTo(numbers.size());
	}

	private static Stream<Arguments> generate() {
		return Stream.of(
			Arguments.of(1),
			Arguments.of(max - min + 1)
		);
	}

	@DisplayName("잘못된 파라미터로 생성시 예외 발생 테스트")
	@ParameterizedTest
	@MethodSource("generate_ShouldThrowIllegalArgumentException")
	void generate_ShouldThrowIllegalArgumentException(int count) {
		assertThatThrownBy(() -> numbersGenerator.generate(count))
			.isInstanceOf(IllegalArgumentException.class);
	}

	private static Stream<Arguments> generate_ShouldThrowIllegalArgumentException() {
		return Stream.of(
			Arguments.of(Integer.MIN_VALUE),
			Arguments.of(-1),
			Arguments.of(0),
			Arguments.of(max - min + 2)
		);
	}
}