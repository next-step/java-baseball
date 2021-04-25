package domain.target;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 10}) //given
	@DisplayName("Ball 의 숫자가 MIN 미만 MAX 초과 일경우 IllegalArgumentException 을 던는지 테스트")
	public void ifBallNumber_OverThanMax_Or_LessThanMin_ThrowIllegalArgumentException(int number) {
		//when, then
		assertThatThrownBy(() -> new Ball(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("숫자는" + Ball.MIN_NUMBER_OF_BALL + "~" + Ball.MAX_NUMBER_OF_BALL + "사이 입니다.");

	}


}
