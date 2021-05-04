package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import view.InputView;

class UserBallNumbersTest {

	public static final int USER_NUMBER_SIZE = 3;

	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "789"})
	@DisplayName("사용자가 1부터 9까지 3자리 정수 입력 한 경우 테스트")
	void createUserBallNumberTest(String userInputNumber) {
		assertThat(createUserBallNumbers(userInputNumber).getUserBallNumbers().size()).isEqualTo(USER_NUMBER_SIZE);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "1234"})
	@DisplayName("사용자가 3자리 정수가 아닌 N자리 정수 입력한 경우 테스트")
	void notEqualLengthUserBallNumberTest(String userInputNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			createUserBallNumbers(userInputNumber);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"012", "가01", "a23", "!23"})
	@DisplayName("입력한 3자리 수가 1부터 9까지 정수가 아닌 경우")
	void notEqualRangeUserBallNumberTest(String userInputNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			createUserBallNumbers(userInputNumber);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"112", "122", "121", "111"})
	@DisplayName("입력한 3자리 수가 중복일 경우 테스트")
	void duplicateUserBallNumberTest(String userInputNumber) {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			createUserBallNumbers(userInputNumber);
		});
	}

	private UserBallNumbers createUserBallNumbers(String userInputNumber) {
		return new UserBallNumbers(InputView.stringToListConvert(userInputNumber));
	}
}
