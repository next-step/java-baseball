package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import input.ParseService;

@DisplayName("문자열 파싱")
class ParseServiceTest {

	private final ParseService parseService = new ParseService();

	public static String[] possibleParsedString() {
		return new String[] {"123", "456", "150"};
	}

	@DisplayName("[성공] 정의된 길이로 parse")
	@ParameterizedTest
	@MethodSource("possibleParsedString")
	public void success_parse(String input) {
		// given
		int size = 3;

		// when
		List<Integer> result = parseService.parse(input, size);

		// then
		assertThat(result.size()).isGreaterThan(0);
	}

	public static String[] impossibleParsedString() {
		return new String[] {"", "   ", "-10", "hello", "java"};
	}

	@DisplayName("[실패] 정의된 길이로 parse - 파싱할 수 없음")
	@ParameterizedTest
	@MethodSource("impossibleParsedString")
	public void fail_parse_impossible(String input) {
		// given
		int size = 3;

		// when
		assertThrows(NumberFormatException.class, () -> parseService.parse(input, size));

		// then
	}

	public static String[] IllegalLengthString() {
		return new String[] {"1", "12", "5555", "1234567"};
	}

	@DisplayName("[실패] 정의된 길이로 parse - 맞지 않는 길이")
	@ParameterizedTest
	@MethodSource("IllegalLengthString")
	public void fail_parse_illegalLength(String input) {
		// given
		int size = 3;

		// when
		assertThrows(IllegalArgumentException.class, () -> parseService.parse(input, size));

		// then
	}
}
