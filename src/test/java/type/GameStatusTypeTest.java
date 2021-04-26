package type;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("게임 상태")
class GameStatusTypeTest {

	public static String[] validFlags() {
		return new String[]{"1", "2"};
	}

	@DisplayName("[성공] flag 로 enum 찾기")
	@ParameterizedTest
	@MethodSource("validFlags")
	public void success_findByFlag(String flagString) {
		// given
		int flag = Integer.parseInt(flagString);

		// when
		GameStatusType result = GameStatusType.findByFlag(flag);

		// then
		assertThat(result).isNotNull();
	}


	public static String[] inValidFlags() {
		return new String[]{"0", "4", "5"};
	}

	@DisplayName("[실패] flag 로 enum 찾기 - 적절하지 않은 flag")
	@ParameterizedTest
	@MethodSource("inValidFlags")
	public void fail_findByFlag(String flagString) {
		// given
		int flag = Integer.parseInt(flagString);

		// when
		assertThrows(IllegalArgumentException.class, () -> GameStatusType.findByFlag(flag));

		// then
	}
}
