package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {
	private Ball com;

	@BeforeEach
	void setUp() {
		com = new Ball(1, 4);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:3:false", "2:4:false", "1:4:true"}, delimiter = ':')
	@DisplayName("클라이언트가 입력한 숫자 & 위치와 정답숫자 & 위치를 비교하여 스크라이크 인지 확인해주는 기능 테스트")
	void strikeTest(int userPosition, int userBallNumber, boolean result) {
		assertThat(com.play(new Ball(userPosition, userBallNumber)).equals(BallStatus.STRIKE)).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:4:false", "2:4:true", "1:5:false"}, delimiter = ':')
	@DisplayName("클라이언트가 입력한 숫자 & 위치와 정답숫자 & 위치를 비교하여 볼 인지 확인해주는 기능 테스트")
	void ballTest(int userPosition, int userBallNumber, boolean result) {
		assertThat(com.play(new Ball(userPosition, userBallNumber)).equals(BallStatus.BALL)).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:3:true", "2:4:false", "1:4:false"}, delimiter = ':')
	@DisplayName("클라이언트가 입력한 숫자 & 위치와 정답숫자 & 위치를 비교하여 낫싱 인지 확인해주는 기능 테스트")
	void nothingTest(int userPosition, int userBallNumber, boolean result) {
		assertThat(com.play(new Ball(userPosition, userBallNumber)).equals(BallStatus.NOTHING)).isEqualTo(result);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 10})
	@DisplayName("사용자의 수가 1부터 9까지 수가 아닐 경우 테스트")
	void notEqualRangeExceptionTest(int randomBallNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Ball(1, randomBallNumber);
		});
	}

}
