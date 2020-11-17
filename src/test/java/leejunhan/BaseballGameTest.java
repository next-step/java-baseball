package leejunhan;

import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballGameTest {

	@Test
	@DisplayName("야구게임 숫자 생성 - 1~9 숫자 3자리인지 체크")
	void getBaseballNumberCheck() {
		String baseballNumber = BaseballGame.getBaseballNumber();
		assertThat(baseballNumber).matches("[1-9]{3}");
	}

	@Test
	@DisplayName("야구게임 숫자 생성 - 중복된 숫자 없는지 체크")
	void getBaseballNumberDuplicate() {
		String baseballNumber = BaseballGame.getBaseballNumber();
		assertThat(baseballNumber.charAt(0)).as("첫번째/두번째 숫자 동일").isNotEqualTo(baseballNumber.charAt(1));
		assertThat(baseballNumber.charAt(0)).as("첫번째/세번째 숫자 동일").isNotEqualTo(baseballNumber.charAt(2));
		assertThat(baseballNumber.charAt(1)).as("두번째/세번째 숫자 동일").isNotEqualTo(baseballNumber.charAt(2));
	}

	@ParameterizedTest
	@CsvSource({"123,123,3", "123,345,0"})
	@DisplayName("스트라이크 개수 조회")
	void getStrike(String baseballNumber, String inputNumber, int strike) {
		assertThat(BaseballGame.getStrike(baseballNumber, inputNumber)).isEqualTo(strike);
	}

	@ParameterizedTest
	@CsvSource({"123,312,3", "123,345,1"})
	@DisplayName("볼 개수 조회")
	void getBall(String baseballNumber, String inputNumber, int ball) {
		assertThat(BaseballGame.getBall(baseballNumber, inputNumber)).isEqualTo(ball);
	}

	@ParameterizedTest
	@CsvSource({"1,2", "2,1"})
	@DisplayName("야구게임결과 - x 스트라이크 y볼")
	void getChallengeResultStrikeAndBall(int strikeCount, int ballCount) {
		assertThat(BaseballGame.getChallengeResult(strikeCount, ballCount))
			.isEqualTo(strikeCount+" 스트라이크 "+ballCount+"볼");
	}

	@ParameterizedTest
	@CsvSource({"1,0", "3,0"})
	@DisplayName("야구게임결과 - x 스트라이크")
	void getChallengeResultStrike(int strikeCount, int ballCount) {
		assertThat(BaseballGame.getChallengeResult(strikeCount, ballCount)).isEqualTo(strikeCount+" 스트라이크");
	}

	@ParameterizedTest
	@CsvSource({"0,2", "0,1"})
	@DisplayName("야구게임결과 - y볼")
	void getChallengeResultBall(int strikeCount, int ballCount) {
		assertThat(BaseballGame.getChallengeResult(strikeCount, ballCount)).isEqualTo(ballCount+"볼");
	}

	@ParameterizedTest
	@CsvSource({"0,0"})
	@DisplayName("야구게임결과 - 낫싱")
	void getChallengeResultNothing(int strikeCount, int ballCount) {
		assertThat(BaseballGame.getChallengeResult(strikeCount, ballCount)).isEqualTo("낫싱");
	}

	private static Stream<Arguments> numberArrayParameter() {
		return Stream.of(
			Arguments.of(new int[]{1,0}),
			Arguments.of(new int[]{5,6})
		);
	}

	@ParameterizedTest
	@MethodSource("numberArrayParameter")
	@DisplayName("숫자 중복되지 않게 생성되는지 체크")
	void getOneRandomNumber(int[] randomNumberArray) {
		int newRandomNumber = BaseballGame.getOneRandomNumber(randomNumberArray);
		for (int randomNumber : randomNumberArray) {
			assertThat(newRandomNumber).isNotEqualTo(randomNumber);
			System.out.println("randomNumber = " + randomNumber);
		}
		System.out.println("newRandomNumber = " + newRandomNumber);
	}

	@RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}" )
	@DisplayName("1~9 사이의 숫자로 생성되는지 체크")
	void getRandomNumberRangeOneToNine() {
		int randomNumber = BaseballGame.getRandomNumberRangeOneToNine();
		System.out.println("randomNumber = " + randomNumber);
		assertThat(randomNumber)
			.as("randomNumber=%d : randomNumber must be between 1 and 9.", randomNumber)
			.isGreaterThan(0).isLessThan(10);
	}

	@ParameterizedTest
	@CsvSource({"1,1", "9,9"})
	@DisplayName("중복숫자 체크 - 기준숫자와 랜덤숫자가 동일함 (중복)")
	void duplicateFlagTrueSuccess(int standardNumber, int randomNumber) {
		System.out.printf("standardNumber = %d, randomNumber = %d", standardNumber, randomNumber);
		assertThat(BaseballGame.duplicateFlag(standardNumber, randomNumber)).isTrue();
	}

	@ParameterizedTest
	@CsvSource({"1,2", "9,1"})
	@DisplayName("중복숫자 체크 - 기준숫자와 랜덤숫자가 다름 (중복아님)")
	void duplicateFlagFalseSuccess(int standardNumber, int randomNumber) {
		System.out.printf("standardNumber = %d, randomNumber = %d", standardNumber, randomNumber);
		assertThat(BaseballGame.duplicateFlag(standardNumber, randomNumber)).isFalse();
	}
}
