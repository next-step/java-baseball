package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.BaseballGame;

class BaseballGoalNumberTest {

	@Test
	@DisplayName("랜덤 야구 숫자 생성")
	void createBaseballGoalNumber() {

		// 랜덤 난수 생성
		BaseballGoalNumber baseballGoal = new BaseballGoalNumber();

		assertThat(baseballGoal.goalNumberArray).isNotNull();
		assertThat(baseballGoal.goalNumberArray.size()).isEqualTo(BaseballGame.BASEBALL_GAME_COUNT);
		System.out.println(baseballGoal.goalNumberArray.toString());
	}
}
