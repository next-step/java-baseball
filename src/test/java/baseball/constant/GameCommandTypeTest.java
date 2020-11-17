package baseball.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("게임 명령어 유형 테스트")
public class GameCommandTypeTest {

	@DisplayName("입력한 명령어가 존재하는 명령어인지 체크 > 성공")
	@Test
	public void isExistType() {
		assertEquals(true, GameCommandType.isExistType("1"));
		assertEquals(true, GameCommandType.isExistType("2"));
		assertEquals(false, GameCommandType.isExistType("3"));
	}
}
