package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.right42.domain.ThreeBall;
import me.right42.exception.BallNumberDuplicationException;

class ThreeBallTest {

	@Test
	@DisplayName("잘못된 볼사이즈 입력 테스트")
	void ballSizeValidateTest(){
		List<Integer> ballNumbers = Arrays.asList(1, 2);

		assertThatThrownBy(() -> ThreeBall.createThreeBall(ballNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("볼 사이즈는 3개입니다.");
	}

	@Test
	@DisplayName("중복된 값 입력 테스트")
	void validateThreeBallTest(){
		List<Integer> ballNumbers = Arrays.asList(1, 2, 2);

		assertThatThrownBy(() -> ThreeBall.createThreeBall(ballNumbers))
			.isInstanceOf(BallNumberDuplicationException.class)
			.hasMessage("볼 값은 중복불가 입니다.");
	}
}
