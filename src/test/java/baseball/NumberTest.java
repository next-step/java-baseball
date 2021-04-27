package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {
	@DisplayName("숫자 검증 - 실패")
	@ParameterizedTest
	@ValueSource(ints = {1, 100, 122, 99999, Integer.MAX_VALUE})
	void isValidate_failed(int input) {
		assertThatIllegalArgumentException().isThrownBy(() -> Number.isValidate(input));
	}

	@DisplayName("숫자 검증 - 성공")
	@Test
	void isValidate_success() {
		assertEquals(Number.isValidate(123), new Number(123));
	}

	@DisplayName("중복 없는 랜덤 숫자 생성")
	@Test
	void getRandomNumberWithoutDuplicate() {
		try {
			Number generateNumber = Number.getRandomNumberWithoutDuplicate();
			Field field = generateNumber.getClass().getDeclaredField("number");
			field.setAccessible(true);
			int privateNumber = (int)field.get(generateNumber);
			assertEquals(Number.isValidate(privateNumber), generateNumber);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
