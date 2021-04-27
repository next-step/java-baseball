package player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import number.UserInputGenerationStrategy;

public class UserTest {

	private Player user;

	@BeforeEach
	void setIp() {
		user = new User(UserInputGenerationStrategy.getInstance());
	}

	@Test
	@DisplayName("baseballNumbers이 발생하였는지 테스트(UI로직: 단위테스트 제외)")
	public void generateNumbers() {
		// user.generateNumbers();
		// assertThat(user.getNumbers()).isExactlyInstanceOf(BaseballNumbers.class).isNotNull();
	}
}
