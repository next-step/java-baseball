import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("static-access")
public class NumberBaseballGameTest {

	NumberBaseballGame numberBaseballGame = new NumberBaseballGame();

	// 1~9까지의 서로 다른 수로 이루어진 digit자리(3)의 수를 생성
	// 요구한 자릿수(3) 만큼의 길이인지 체크
	@ParameterizedTest
	@ValueSource(ints = {NumberBaseballGame.RANDOM_DIGIT})
	public void testLengthGenerateRandomNumDigit(int index) {
		int actual = (numberBaseballGame.generateRandomNumDigit(numberBaseballGame.RANDOM_DIGIT) + "").length();
		assertThat(actual).isEqualTo(index);
	}
	
	// 1~9까지의 서로 다른 수로 이루어진 digit자리(3)의 수를 생성
	// 서로 다른 수인지 체크
	@Test
	public void testDiffGenerateRandomNum() {
		int number = numberBaseballGame.generateRandomNumDigit(numberBaseballGame.RANDOM_DIGIT);

		String[] numberArr = (number + "").split("");

		for (String string : numberArr) {
			assertThat(getCharNumber(number + "", string.charAt(0))).isEqualTo(1);
		}
	}
	
	// 1~9까지의 서로 다른 수로 이루어진 digit자리(3)의 수를 생성
	// 최대 9자리인지 체크
	@Test
	public void testMaxLengthGenerateRandomNum() {
		int number = numberBaseballGame.generateRandomNumDigit(numberBaseballGame.RANDOM_DIGIT);
		boolean actual = (0 < (number + "").length()) && ((number + "").length() < 10);

		assertThat(actual).isTrue();
	}
	
	// 볼카운트 체크가 제대로 되는지 테스트
	// 카운트 범위가 0 ~ 자릿수(3)인지 체크
	@Test
	public void testLengthCountBall() {
		int number = numberBaseballGame.countBall(123, 234);
		boolean actual = (0 <= number) && (number <= numberBaseballGame.RANDOM_DIGIT);
	
		assertThat(actual).isTrue();
	}
	
	// 스트라이크 카운트가 제대로 되는지 테스트
	// 카운트 범위가 0 ~ 자릿수(3)인지 체크
	@Test
	public void testLengthCountStrike() {
		int number = numberBaseballGame.countStrike(123, 234);
		boolean actual = (0 <= number) && (number <= numberBaseballGame.RANDOM_DIGIT);
	
		assertThat(actual).isTrue();
	}
	
	/**
	 * 
	 * 문자열내에 같은 문자가 몇개있는지 체크
	 * 
	 * @param str 체크할 문자열, char 갯수 체크할 문자열
	 * @return count 같은 문자갯수
	 * 
	 */
	private int getCharNumber(String str, char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
		}
		return count;
	}
}
