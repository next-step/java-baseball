package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.right42.domain.BallNumber;

class BallNumberTest {

	@Test
	@DisplayName("객체간의 비교테스트")
	void ballNumberCompareTest() {
		BallNumber ballNumber1 = new BallNumber(1);
		BallNumber ballNumber2 = new BallNumber(1);
		BallNumber ballNumber3 = new BallNumber(2);

		assertThat(ballNumber1)
			.isEqualTo(ballNumber2)
			.isNotEqualTo(ballNumber3)
		;
	}

	@Test
	@DisplayName("볼사이즈 최대값 초과 데이터 넣기")
	void ballNumberValidationTest(){
		int ballSize = 11;

		assertThatThrownBy(() -> new BallNumber(ballSize))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("볼의 사이즈는 1 이상 9 이하 입니다.")
		;
	}
}
