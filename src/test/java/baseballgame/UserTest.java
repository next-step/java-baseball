package baseballgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {

	User user;

	@BeforeEach
	void setUser() {
		this.user = new User();
	}

	@ParameterizedTest
	@ValueSource(strings = {"1234", "12", "12345", "", "1"})
	@DisplayName("User 가 입력한 input 값이 3자리가 아니면 IllegalArgumentException 이 발생하는지 테스트.")
	void validateInputLength(String userInput) {
		assertThrows(IllegalArgumentException.class, () -> user.validateInput(userInput));
	}

	@ParameterizedTest
	@ValueSource(strings = {"12d", "sss", " ff", " ", "123 "})
	@DisplayName("User 가 입력한 input 값에 숫자가 아닌값이 포함되어있으면 IllegalArgumentException 이 발생되는지 테스트.")
	void validateInputPattern(String userInput) {
		assertThrows(IllegalArgumentException.class, () -> user.validateInput(userInput));
	}
}
