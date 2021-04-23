package study;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.BaseballGame;
import baseball.BaseballGame.BallCount;

public class BaseballTest {

	private BaseballGame baseballGame = new BaseballGame();
	private List<Integer> inputListValue;
	private List<Integer> randomListValue;
	
	@BeforeEach
	public void init() {
		inputListValue = BaseballGame.generateRandomIntegerList(3);
		randomListValue = BaseballGame.generateRandomIntegerList(3);
	}
	
	@Test
	@DisplayName("임의의 숫자 생성 기능 테스트")
	public void generate_random_list_test() {
		assertThat(inputListValue).isNotEqualTo(randomListValue);
	}
	
	@Test
	@DisplayName("볼카운트 모두 스트라이크 성공 테스트")
	public void ballcount_all_strike_pass_test() {
		BallCount ballcnt = BaseballGame.ballCount(Arrays.asList(1,2,3), Arrays.asList(1,2,3));
		assertThat(ballcnt.isAllStrike())
			.isEqualTo(true);
	}
	
	@Test
	@DisplayName("볼카운트 모두 스트라이크 실패 테스트")
	public void ballcount_all_strike_fail_test() {
		BallCount ballcnt = BaseballGame.ballCount(Arrays.asList(1,2,4), Arrays.asList(1,2,3));
		assertThat(ballcnt.isAllStrike())
			.isEqualTo(false);
	}
}
