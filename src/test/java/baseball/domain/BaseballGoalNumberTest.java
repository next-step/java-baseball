package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.dao.BaseballConstant;

class BaseballGoalNumberTest {

	@Test
	@DisplayName("랜덤 야구 숫자 생성")
	void createBaseballGoalNumber() {

		// 랜덤 난수 생성
		BaseballGoalNumber baseballGoal = new BaseballGoalNumber();

		assertThat(baseballGoal.baseballGoalNumber).isNotNull();
		assertThat(baseballGoal.baseballGoalNumber.size()).isEqualTo(BaseballConstant.BASEBALL_GAME_COUNT);
		System.out.println(baseballGoal.baseballGoalNumber.toString());
	}
}
