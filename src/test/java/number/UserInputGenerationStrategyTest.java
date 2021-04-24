package number;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputGenerationStrategyTest {
	private NumbersGenerationStrategy userInputGenerationStrategy;

	@BeforeEach
	void setIp() {
		userInputGenerationStrategy = UserInputGenerationStrategy.getInstance();
	}

	@Test
	@DisplayName("유저입력에 의한 숫자가 발생(UI로직: 단위테스트 제외)")
	void generate() {
		//assertThat(userInputGenerationStrategy.generate()).isExactlyInstanceOf(BaseballNumbers.class).isNotNull();
	}
}
