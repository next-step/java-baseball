package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class NumberBaseballGameCommandTest {
	@ParameterizedTest
	@DisplayName("isContinue: should return if code is Continue command's value")
	@CsvSource(value = {"1:true", "2:false", "3:false"}, delimiter = ':')
	void isContinue_Should_ReturnIfCodeIsContinueCommandValue(int input, boolean expected) {
		boolean result = NumberBaseballGameCommand.isContinue(input);
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("isTerminate: should return if code is Terminate command's value")
	@CsvSource(value = {"1:false", "2:true", "3:false"}, delimiter = ':')
	void isTerminate_Should_ReturnIfCodeIsTerminateCommandValue(int input, boolean expected) {
		boolean result = NumberBaseballGameCommand.isTerminate(input);
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("validateCommand: should return if code is one of valid command values")
	@CsvSource(value = {"1:true", "2:true", "3:false"}, delimiter = ':')
	void validateCommand_Should_ReturnIfCodeIsValidCommandValue(String input, boolean expected) {
		boolean result = NumberBaseballGameCommand.validateCommand(Integer.valueOf(input));
		assertThat(result).isEqualTo(Boolean.valueOf(expected));
	}
}
