package precourse.game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import precourse.baseball.BaseballGenerator;
import precourse.baseball.Baseballs;

class BaseballGameResultTest {

	@DisplayName("야구 게임 결과의 경우의 수를 검사한다.")
	@ParameterizedTest(name = "{0} vs {1} : {2}")
	@CsvSource(
		value = {
			"123,123,3개의 숫자를 모두 맞히셨습니다! 게임 종료",
			"123,125,2스트라이크",
			"123,145,1스트라이크",
			"123,312,3볼",
			"123,234,2볼",
			"123,321,2볼 1스트라이크",
			"123,451,1볼",
			"123,134,1볼 1스트라이크",
			"123,456,낫싱"
		}
	)
	void correctAnswer(String stringNumber1, String stringNumber2, String expectedResult) {
		BaseballGenerator generator = new BaseballGenerator();
		Baseballs baseballs1 = generator.createBaseballs(stringNumber1);
		Baseballs baseballs2 = generator.createBaseballs(stringNumber2);
		BaseballGameResult baseballGameResult = new BaseballGameResult(baseballs1, baseballs2);

		String result = baseballGameResult.getResult();

		assertThat(result).isEqualTo(expectedResult);
	}

}