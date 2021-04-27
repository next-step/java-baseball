package baseball.service;

import baseball.config.AppContext;
import baseball.domain.BallCount;
import baseball.error.DuplicateCharactersException;
import baseball.error.NonNumericCharactersException;
import org.assertj.core.api.ThrowableTypeAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BallCountServiceTest {
	private BallCountService ballCountService;

	@BeforeEach
	void setUp() {
		ballCountService = AppContext.getInstance().getBallCountService();
	}

	@Test
	@DisplayName("1~9 서로 다른 3자리 난수 생성")
	void generateNumbers() {
		assertThat(ballCountService.generateNumbers()).allMatch(i -> i > 0).hasSize(3);
	}

	@Test
	@DisplayName("사용자 입력 문자 구문 분석")
	void parseNumbers() {
		assertThat(ballCountService.parseNumbers("123")).containsExactly(1, 2, 3);
		assertThat(ballCountService.parseNumbers("413")).containsExactly(4, 1, 3);

		ThrowableTypeAssert<NullPointerException> nullPointer = assertThatExceptionOfType(NullPointerException.class);
		nullPointer.isThrownBy(() -> ballCountService.parseNumbers(null));

		ThrowableTypeAssert<NonNumericCharactersException> nonNumericCharacters = assertThatExceptionOfType(NonNumericCharactersException.class);
		nonNumericCharacters.isThrownBy(() -> ballCountService.parseNumbers("019"));
		nonNumericCharacters.isThrownBy(() -> ballCountService.parseNumbers(""));
		nonNumericCharacters.isThrownBy(() -> ballCountService.parseNumbers("   "));
		nonNumericCharacters.isThrownBy(() -> ballCountService.parseNumbers("1a3"));
		nonNumericCharacters.isThrownBy(() -> ballCountService.parseNumbers("1a1"));
		nonNumericCharacters.isThrownBy(() -> ballCountService.parseNumbers("123 "));
		nonNumericCharacters.isThrownBy(() -> ballCountService.parseNumbers(" 123 "));

		ThrowableTypeAssert<DuplicateCharactersException> duplicateCharacters = assertThatExceptionOfType(DuplicateCharactersException.class);
		duplicateCharacters.isThrownBy(() -> ballCountService.parseNumbers("112"));
		duplicateCharacters.isThrownBy(() -> ballCountService.parseNumbers("122"));
	}

	@Test
	@DisplayName("생성된 숫자와 사용자가 입력한 숫자를 비교")
	void compareNumbers() {
		List<Integer> generateNumbers = Arrays.asList(1, 2, 3);
		List<Integer> parseNumbers = Arrays.asList(3, 1, 2);
		assertThat(ballCountService.compareNumbers(generateNumbers, parseNumbers)).isEqualTo(new BallCount(0, 3));

		generateNumbers = Arrays.asList(4, 9, 8);
		parseNumbers = Arrays.asList(4, 9, 8);
		assertThat(ballCountService.compareNumbers(generateNumbers, parseNumbers)).isEqualTo(new BallCount(3, 0));

		generateNumbers = Arrays.asList(4, 9, 8);
		parseNumbers = Arrays.asList(4, 2, 8);
		assertThat(ballCountService.compareNumbers(generateNumbers, parseNumbers)).isEqualTo(new BallCount(2, 0));

		generateNumbers = Arrays.asList(1, 9, 8);
		parseNumbers = Arrays.asList(9, 1, 8);
		assertThat(ballCountService.compareNumbers(generateNumbers, parseNumbers)).isEqualTo(new BallCount(1, 2));
	}
}