package machine;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MachineTest {

	@Test
	@DisplayName("플레이어가 없는 경우 에러를 던진다")
	void throwErrorIfUserDontExist() {
		// given
		Machine machine = new Machine();

		// when

		// then
		assertThatIllegalArgumentException().isThrownBy(machine::run);
	}
}
