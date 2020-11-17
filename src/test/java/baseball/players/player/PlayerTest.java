package baseball.players.player;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.utils.DataConvertUtils;

class PlayerTest {

	@Test
	void getRequestNumbers() {
	}

	@Test
	void isContinue() {
	}

	@DisplayName("요청 숫자 유효성 확인")
	@ParameterizedTest()
	@ValueSource(strings = {"123", "453"})
	public void toCheckValidNumbers(String strNumbers) {
		Player player = new TestPlayer(strNumbers);
		List<Integer> requestNumbers = player.getRequestNumbers();

		assertThat(requestNumbers).isEqualTo(DataConvertUtils.convertToIntegerArrays(strNumbers));
	}

	@DisplayName("요청 숫자 유효성 확인")
	@ParameterizedTest()
	@CsvSource(value = {":false", "1W2:false", "102:false", "1324:false", "122:false", "1:false"}, delimiter = ':')
	public void toCheckInvalidNumbers(String strNumbers, boolean expected) {

		assertThatIllegalArgumentException().isThrownBy(() -> {
			Player player = new TestPlayer(strNumbers);
			player.getRequestNumbers();
		})
		;
	}

	@DisplayName("계속 할 지 여부 확인")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:false", "3:false", "f:false"}, delimiter = ':')
	public void toCheckContinues(String requestNumber, boolean expected) {
		TestPlayer player = new TestPlayer("123");
		player.setContinue(requestNumber);
		boolean isContinue = player.isContinue();

		assertThat(isContinue).isEqualTo(expected);
	}


}
