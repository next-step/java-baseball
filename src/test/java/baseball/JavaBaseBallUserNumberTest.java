package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JavaBaseBallUserNumberTest {
	
	JavaBaseBallUserNumber baseBallUserNumber = new JavaBaseBallUserNumber();

	@Test
	@DisplayName("입력된 값이 숫자인지 체크한다.")
	void validateUserNumberTest() {
		assertThat(baseBallUserNumber.validateUserNumber("2a3"))
			.isEqualTo(false);
	}
	
	@Test
	@DisplayName("숫자의 길이가 3인지 체크한다.")
	void checkUserNumberLengthTest() {
		assertThat(baseBallUserNumber.checkUserNumberLength("243"))
			.isEqualTo(true);
	}
}
