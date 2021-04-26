import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
	
	@Test
	@DisplayName("3자리 난수생성 테스트")
	void createRandomNumberTest() {
		String randomNumber = createRandomNumber();
		assertThat(randomNumber.length()).isEqualTo(3);
	}
	
	private String createRandomNumber() {
		double randomNumber = Math.random() * 1000;
		return String.format("%.0f", randomNumber);
	}
	
}
