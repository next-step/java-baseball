package number;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballNumbersFactoryTest {
	private BaseballNumbersFactory baseballNumbersFactory;

	@BeforeEach
	void setIp() {
		baseballNumbersFactory = BaseballNumbersFactory.getInstance();
	}

	@Test
	@DisplayName("int형 input에 의해 BaseballNumbers 발생")
	void baseballNumbers() {
		assertThat(baseballNumbersFactory.baseballNumbers(123)).isExactlyInstanceOf(BaseballNumbers.class);
	}
}
