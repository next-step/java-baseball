package baseball.game.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CommandTest {

	@ParameterizedTest
	@CsvSource(value = {"1:AGAIN", "2:EXIT", "3:UNKNOWN"}, delimiter = ':')
	@DisplayName("보유한 명령어와 일치한 문자열 입력시 보유하고 있다는 결과값을 반환한다")
	public void should_containsTrue_When_hasCommandName(String input, String name) {

		// Given
		String command = input.trim().toLowerCase();

		// When
		Command cmd = Command.parse(command);

		// Then
		assertThat(cmd.name()).isEqualTo(name);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
	@DisplayName("입력받은 유효한 명령어를 통해 재시작 여부를 판단한다")
	public void should_validCondition_When_canRestartInputCommand(String input, boolean condition) {
		// Given
		String command = input.trim().toLowerCase();

		// When
		Command cmd = Command.parse(command);
		boolean canAgain = Command.canAgain(cmd);

		// Then
		assertThat(canAgain).isEqualTo(condition);

	}

}