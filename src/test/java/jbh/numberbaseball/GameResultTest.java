package jbh.numberbaseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultTest {

	@ParameterizedTest
	@CsvSource(value = {"0:0:false:false", "1:0:true:false", "2:0:true:false", "3:0:true:false", "0:1:false:true",
		"0:2:false:true", "0:3:false:true", "1:2:true:true", "2:3:true:true", "3:2:true:true"}, delimiter = ':')
	@DisplayName("GameResult_클래스_초기화_및_스트라이크_볼_여부_확인")
	public void gameResultSettingAndContainTest(int strikeCount, int ballCount, boolean strikeExists, boolean ballExists) {
		GameResult gameResult = new GameResult(strikeCount, ballCount);
		assertThat(gameResult.hasStrike()).isEqualTo(strikeExists);
		assertThat(gameResult.hasBall()).isEqualTo(ballExists);
	}

	@ParameterizedTest
	@CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "0:1", "0:2", "0:3", "1:2", "2:3", "3:2"}, delimiter = ':')
	@DisplayName("GameResult_클래스_초기화_및_스트라이크_볼_개수_확인")
	public void gameResultSettingAndCountCheckTest(int strikeCount, int ballCount) {
		GameResult gameResult = new GameResult(strikeCount, ballCount);
		assertThat(gameResult.getStrikeCount()).isEqualTo(strikeCount);
		assertThat(gameResult.getBallCount()).isEqualTo(ballCount);
	}

	@ParameterizedTest
	@CsvSource(value = {"0:false", "1:false", "2:false", "3:true"}, delimiter = ':')
	@DisplayName("GameResult_클래스_초기화_및_3스트라이크_아웃_여부_확인")
	public void gameResultSettingAndOutTest(int strikeCount, boolean out) {
		GameResult gameResult = new GameResult(strikeCount, 0);
		assertThat(gameResult.isOut()).isEqualTo(out);
	}

	@ParameterizedTest
	@CsvSource(value = {"0:0:true", "1:0:false", "2:0:false", "3:0:false", "0:1:false", "0:2:false", "0:3:false",
		"1:2:false", "2:3:false", "3:2:false"}, delimiter = ':')
	@DisplayName("GameResult_클래스_초기화_및_낫싱_여부_확인")
	public void gameResultSettingAndNothingTest(int strikeCount, int ballCount, boolean nothing) {
		GameResult gameResult = new GameResult(strikeCount, ballCount);
		assertThat(gameResult.isNothing()).isEqualTo(nothing);
	}
}
