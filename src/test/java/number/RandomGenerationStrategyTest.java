package number;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomGenerationStrategyTest {
	private NumbersGenerationStrategy randomGenerationStrategy;

	@BeforeEach
	void setIp() {
		randomGenerationStrategy = RandomGenerationStrategy.getInstance();
	}

	@Test
	@DisplayName("랜덤으로 숫자가 발생")
	void generate() {
		assertThat(randomGenerationStrategy.generate()).isExactlyInstanceOf(BaseballNumbers.class).isNotNull();		
	}
}
