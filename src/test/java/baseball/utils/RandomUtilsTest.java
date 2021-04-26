package baseball.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {
	RandomUtils randomUtils;

	@Test
	@DisplayName("테스트 01. min이 max보다 크면 실패")
	public void illegalArgumentTest01() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> randomUtils.createRandomNumber(9, 1));
		assertThat(exception.getMessage()).isEqualTo("입력값이 잘못되었습니다.");
	}

	@Test
	@DisplayName("테스트 02. min이 1보다 작으면 실패")
	public void illegalArgumentTest02() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> randomUtils.createRandomNumber(0, 9));
		assertThat(exception.getMessage()).isEqualTo("입력값이 잘못되었습니다.");
	}

	@Test
	@DisplayName("테스트 03. min이 max가 같으면 실패")
	public void illegalArgumentTest03() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> randomUtils.createRandomNumber(1, 1));
		assertThat(exception.getMessage()).isEqualTo("입력값이 잘못되었습니다.");
	}

	@Test
	@DisplayName("테스트 04. 중복값 없으면 성공")
	public void illegalArgumentTest04() {
		int[] result = randomUtils.createRandomNumber(1, 9);
		assertThat(result[0]).isNotEqualTo(result[1]);
		assertThat(result[0]).isNotEqualTo(result[2]);
		assertThat(result[1]).isNotEqualTo(result[2]);
	}
}
