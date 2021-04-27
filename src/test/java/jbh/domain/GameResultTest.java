package jbh.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class GameResultTest {

	@ParameterizedTest
	@CsvSource(value = {"0:0:false:false", "1:0:true:false", "2:0:true:false", "3:0:true:false", "0:1:false:true",
		"0:2:false:true", "0:3:false:true", "1:2:true:true", "2:3:true:true", "3:2:true:true"}, delimiter = ':')
	@DisplayName("GameResult 클래스 초기화 후 스트라이크/볼 여부 확인")
	public void gameResultSettingAndContainTest(int strikeCount, int ballCount, boolean strikeExists, boolean ballExists) {
		GameResult gameResult = new GameResult(strikeCount, ballCount);
		assertThat(gameResult.hasStrike()).isEqualTo(strikeExists);
		assertThat(gameResult.hasBall()).isEqualTo(ballExists);
	}

	@ParameterizedTest
	@CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "0:1", "0:2", "0:3", "1:2", "2:3", "3:2"}, delimiter = ':')
	@DisplayName("GameResult 클래스 초기화 후 스트라이크/볼 여부 확인")
	public void gameResultSettingAndCountCheckTest(int strikeCount, int ballCount) {
		GameResult gameResult = new GameResult(strikeCount, ballCount);
		assertThat(gameResult.getStrikeCount()).isEqualTo(strikeCount);
		assertThat(gameResult.getBallCount()).isEqualTo(ballCount);
	}

	@ParameterizedTest
	@CsvSource(value = {"0:false", "1:false", "2:false", "3:true"}, delimiter = ':')
	@DisplayName("GameResult 클래스 초기화 후 3 스트라이크(아웃) 여부 확인")
	public void gameResultSettingAndOutTest(int strikeCount, boolean out) {
		GameResult gameResult = new GameResult(strikeCount, 0);
		assertThat(gameResult.isOut()).isEqualTo(out);
	}

	@ParameterizedTest
	@CsvSource(value = {"0:0:true", "1:0:false", "2:0:false", "3:0:false", "0:1:false", "0:2:false", "0:3:false",
		"1:2:false", "2:3:false", "3:2:false"}, delimiter = ':')
	@DisplayName("GameResult 클래스 초기화 후 낫싱 여부 확인")
	public void gameResultSettingAndNothingTest(int strikeCount, int ballCount, boolean nothing) {
		GameResult gameResult = new GameResult(strikeCount, ballCount);
		assertThat(gameResult.isNothing()).isEqualTo(nothing);
	}
}
