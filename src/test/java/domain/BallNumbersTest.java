package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.right42.domain.BallNumbers;
import me.right42.exception.BallNumberDuplicationException;

class BallNumbersTest {

	@Test
	@DisplayName("잘못된 볼사이즈 입력 테스트")
	void ballSizeValidateTest(){
		String value = "12";

		assertThatThrownBy(() -> BallNumbers.create(value))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("볼 사이즈는 3개입니다.");
	}

	@Test
	@DisplayName("중복된 값 입력 테스트")
	void validateThreeBallTest(){
		String value = "122";

		assertThatThrownBy(() -> BallNumbers.create(value))
			.isInstanceOf(BallNumberDuplicationException.class)
			.hasMessage("볼 값은 중복불가 입니다.");
	}
}
