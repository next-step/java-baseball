package baseball.game.play;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.game.constants.ErrorMessage;
import baseball.game.constants.GameStatusType;
import baseball.game.exception.NotAllowedLengthException;

/**
 * @author 박준영
 **/
class BaseballTest {
	private List<Integer> numbers;
	private Baseball baseball;

	@BeforeEach
	void setUp() {
		numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(5);
		numbers.add(3);
	}
	
	@Test
	@DisplayName("야구게임 입력시 숫자가 아닌 값을 넣을 경우 NumberFormatException 발생 테스트")
	void validationCheck() {
		baseball = new Baseball();
		String input = "abc";
		assertThatExceptionOfType(NumberFormatException.class).isThrownBy( () -> {
			baseball.validationCheck(input);
		}).withMessageMatching(ErrorMessage.NOT_INPUT_FORMAT.getMessage());
	}

	@Test
	@DisplayName("야구게임 입력시 숫자인데 길이가 3이 아닌 경우 테스트")
	void validationSizeCheck() {
		baseball = new Baseball();
		String input = "1233";
		assertThatExceptionOfType(NotAllowedLengthException.class).isThrownBy( () -> {
			baseball.validationCheck(input);
		}).withMessageMatching(ErrorMessage.NOW_ALLOWED_LENGTH.getMessage());

	}

	@Test
	@DisplayName("중복되지 않는 세자리 임의의 숫자 생성")
	void generatedComputerNumbers() {
		baseball = new Baseball();
		baseball.generatedComputerNumbers();
		assertThat(baseball.getComputerNumbers().size()).isEqualTo(3);
	}

	@ParameterizedTest
	@CsvSource(value = {"153:3", "567:0"}, delimiter = ':')
	@DisplayName("입력값에 따른 스트라이크 카운트 테스트")
	public void checkNumbersStrike(String input, int expected) {
		baseball = new Baseball(numbers);
		baseball.checkNumbers(input);
		assertThat(baseball.getStrikeCounts()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"153:0", "567:1"}, delimiter = ':')
	@DisplayName("입력값에 따른 볼 카운트 테스트")
	public void checkNumbersBall(String input, int expected) {
		baseball = new Baseball(numbers);
		baseball.checkNumbers(input);
		assertThat(baseball.getBallCounts()).isEqualTo(expected);
	}

	@DisplayName("입력값에 따른 스트라이크/볼 수 맞는 메시지 출력 확인")
	@ParameterizedTest
	@CsvSource(value = {"153: 3 스트라이크", "235: 2 볼", "531: 3 볼", "567: 1 볼", "158: 2 스트라이크"}, delimiter = ':')
	void printResultMessage(String input, String expected) {
		baseball = new Baseball(numbers);
		baseball.checkNumbers(input);
		assertThat(baseball.getResultMessage()).contains(expected);
	}


}