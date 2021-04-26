package precourse.game;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static precourse.constant.BaseballGameMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserChoiceTest {

	@ParameterizedTest(name = "입력값 : {0}")
	@ValueSource(strings = {"1"})
	@DisplayName("새로운 게임을 시작하려면 1번을 선택한다.")
	void choiceNewGame(String choice) {
		UserChoice userChoice = new UserChoice(choice);

		assertThat(userChoice.isStartNewGame()).isTrue();
	}

	@ParameterizedTest(name = "입력값 : {0}")
	@ValueSource(strings = {"2"})
	@DisplayName("게임을 종료하려면 2번을 선택한다.")
	void choiceQuitGame(String choice) {
		UserChoice userChoice = new UserChoice(choice);

		assertThat(userChoice.isQuitGame()).isTrue();
	}

	@ParameterizedTest(name = "입력값 : {0}")
	@ValueSource(strings = {"1", "2"})
	@DisplayName("사용자 선택 시 입력값은 1 또는 2만 가능하다.")
	void validUserChoice(String choice) {
		assertDoesNotThrow(() -> new UserChoice(choice));
	}

	@ParameterizedTest(name = "입력값 : {0}")
	@ValueSource(strings = {"0", "5", "10"})
	@DisplayName("사용자 선택 시 입력값이 1 또는 2가 아니면 예외가 발생한다.")
	void invalidUserChoice(String choice) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new UserChoice(choice))
			.withMessage(INVALID_ANSWER.content());
	}

}