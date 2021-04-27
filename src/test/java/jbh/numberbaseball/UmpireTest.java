package jbh.numberbaseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UmpireTest {

	Umpire umpire = new Umpire();

	@ParameterizedTest
	@CsvSource(value = {"123:173", "876:872", "341:134", "986:126", "265:162", "234:987"}, delimiter = ':')
	@DisplayName("심판_판정결과_객체_존재유무_확인")
	public void umpireResultInstanceNotNullTest(String defenceBall, String userBall) {
		GameResult gameResult = umpire.judgePitching(defenceBall, userBall);
		assertThat(gameResult).isNotNull();
	}

	@ParameterizedTest
	@CsvSource(value = {"123:123:true", "876:876:true", "341:341:true", "986:986:true", "265:234:false", "754:912:false"}, delimiter = ':')
	@DisplayName("심판_판정결과_아웃여부_확인")
	public void umpireStrikeOutTest(String defenceBall, String userBall, boolean out) {
		GameResult gameResult = umpire.judgePitching(defenceBall, userBall);
		assertThat(gameResult).isNotNull();
		assertThat(gameResult.isOut()).isEqualTo(out);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:173:false", "876:872:false", "341:341:false", "986:126:false", "265:971:true", "234:987:true"}, delimiter = ':')
	@DisplayName("심판_판정결과_낫싱여부_확인")
	public void umpireNothingTest(String defenceBall, String userBall, boolean nothing) {
		GameResult gameResult = umpire.judgePitching(defenceBall, userBall);
		assertThat(gameResult.isNothing()).isEqualTo(nothing);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:173:true:false", "876:872:true:false", "341:134:false:true", "986:126:true:false", "265:162:true:true", "234:987:false:false"}, delimiter = ':')
	@DisplayName("심판_판정결과_스트라이크_볼_카운트_유무_확인")
	public void umpireHasCountTest(String defenceBall, String userBall, boolean strike, boolean ball) {
		GameResult gameResult = umpire.judgePitching(defenceBall, userBall);
		assertThat(gameResult.hasStrike()).isEqualTo(strike);
		assertThat(gameResult.hasBall()).isEqualTo(ball);
	}
}
