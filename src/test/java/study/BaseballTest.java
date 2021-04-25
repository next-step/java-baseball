package study;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.BaseballGame;
import baseball.BaseballGame.BallCount;

public class BaseballTest {
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
		BallCount ballcnt = BaseballGame.takeBallCount(Arrays.asList(1,2,3), Arrays.asList(1,2,3));
		assertThat(ballcnt.isAllStrike())
			.isEqualTo(true);
	}
	
	@Test
	@DisplayName("볼카운트 모두 스트라이크 실패 테스트")
	public void ballcount_all_strike_fail_test() {
		BallCount ballcnt = BaseballGame.takeBallCount(Arrays.asList(1,2,4), Arrays.asList(1,2,3));
		assertThat(ballcnt.isAllStrike())
			.isEqualTo(false);
	}
	
	@Test
	@DisplayName("정수값 여부 통과 테스트")
	public void is_integer_value_pass_test() {
		assertThat(BaseballGame.isIntegerValue("123"))
			.isEqualTo(true);
	}
	
	@Test
	@DisplayName("정수값 여부 실패 테스트")
	public void is_integer_value_fail_test() {
		assertThat(BaseballGame.isIntegerValue("안녕하세요1234"))
			.isEqualTo(false);
	}
	
	@Test
	@DisplayName("중복 숫자 존재여부 통과 테스트")
	public void validate_duplicate_number_pass_test() {
		assertThat(BaseballGame.validateDuplicateNumber("873"))
			.isEqualTo(true);
	}
	
	@Test
	@DisplayName("중복 숫자 존재여부 실패 테스트")
	public void validate_duplicate_number_fail_test() {
		assertThat(BaseballGame.validateDuplicateNumber("883"))
			.isEqualTo(false);
	}
}
