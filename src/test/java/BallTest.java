import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThat;

import engine.Ball;

public class BallTest {
	private static final int ANSWER_LENGTH = 3;

	@Test
	@DisplayName("볼 잘못된 길이로 생성시 ExceptionTest")
	void newBall_WhenConstructed_ShouldReturnException() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Ball("1323", ANSWER_LENGTH));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Ball(11));
	}

	@DisplayName("두 볼의 숫자가 같을 경우 같은 볼로 인식하는지 Test")
	@ParameterizedTest
	@CsvSource(value = {
		"159,159"
	})
	void equals_WhenCalled_ShouldReturnBoolean(String input, String answer) throws Exception {
		assertThat(new Ball(input, ANSWER_LENGTH)).isEqualTo(new Ball(answer, ANSWER_LENGTH));
	}

	@DisplayName("정확한 갯수의 strike 갯수를 반환하는지 Test")
	@ParameterizedTest
	@CsvSource(value = {
		"159,159,3",
		"456,416,2",
		"243,256,1",
		"243,789,0"
	})
	void getStrike_WhenCalled_ShouldReturnInt(String input, String answer, int strike) throws Exception {
		assertThat(new Ball(input, ANSWER_LENGTH).getStrike(new Ball(answer, ANSWER_LENGTH))).isEqualTo(strike);
	}

	@DisplayName("정확한 갯수의 ball 갯수를 반환하는지 Test")
	@ParameterizedTest
	@CsvSource(value = {
		"159,591,3",
		"456,648,2",
		"243,872,1",
		"243,789,0"
	})
	void getBall_WhenCalled_ShouldReturnInt(String input, String answer, int ball) throws Exception {
		assertThat(new Ball(input, ANSWER_LENGTH).getBall(new Ball(answer, ANSWER_LENGTH))).isEqualTo(ball);
	}

}
