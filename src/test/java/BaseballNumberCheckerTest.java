import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

import data.BaseballNumbers;

public class BaseballNumberCheckerTest {

	private  BaseballNumberChecker checker;

	@BeforeEach
	public void init() {
		this.checker = new BaseballNumberChecker();
	}

	@DisplayName("힌트 테스트")
	@ParameterizedTest
	@CsvSource({
		"123,123,3 스트라이크",
		"572,592,2 스트라이크",
		"321,123,1 스트라이크 2 볼",
		"321,423,1 스트라이크 1 볼",
		"428,123,1 스트라이크",
		"951,519,3 볼",
		"629,972,2 볼",
		"562,281,1 볼",
		"123,456,낫싱"
	})
	public void testHint(
		@ConvertWith(BaseBallNumbersConverter.class) BaseballNumbers input,
		@ConvertWith(BaseBallNumbersConverter.class) BaseballNumbers answer,
		String hintString
	) {
		assertThat(checker.getHint(input, answer).toHintString()).hasToString(hintString);
	}

	static class BaseBallNumbersConverter extends SimpleArgumentConverter {
		@Override
		protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
			assertEquals(BaseballNumbers.class, targetType, () -> "BaseballNumbers 타입으로만 변환 가능합니다.");
			List<Integer> numbers = new ArrayList<>();
			for(char ch : source.toString().toCharArray()) {
				numbers.add(Character.getNumericValue(ch));
			}
			return new BaseballNumbers(numbers);
		}
	}
}