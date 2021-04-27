import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerInputValidatorTest {
	@Test
	@DisplayName("플레이어가 입력한 숫자 배열의 길이를 확인한다")
	public void validatePlayerNumbersLengthTest() {
		int[] playerInputNumbers = {1, 2, 3};
		assertEquals(true, PlayerInputValidator.validatePlayerNumbersLength(playerInputNumbers));
	}

	@Test
	@DisplayName("플레이어가 입력한 숫자 배열의 중복을 확인한다")
	public void validatePlayerNumbersDuplicate() {
		int[] playerInputNumbers = {1, 2, 3};
		assertEquals(true, PlayerInputValidator.validatePlayerNumbersLength(playerInputNumbers));
	}
}