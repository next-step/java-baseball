import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberBaseballGameTest {
	
	NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
	
	// 1~9까지의 서로 다른 수로 이루어진 digit자리(3)의 수를 생성
	// 요구한 자릿수(3) 만큼의 길이인지 체크
	@ParameterizedTest
	@ValueSource(ints = {NumberBaseballGame.RANDOM_DIGIT})
	public void testLengthGenerateRandomNumDigit(int index) {
		@SuppressWarnings("static-access") 
		int actual = (numberBaseballGame.generateRandomNumDigit(numberBaseballGame.RANDOM_DIGIT) + "").length();
		assertThat(actual).isEqualTo(index);
	}
}
