package rule;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import number.BaseballNumbers;
import number.BaseballNumbersFactory;


public class RuleTest {
	private Rule rule;
	private BaseballNumbers baseballNumbers1;
	private BaseballNumbers baseballNumbers2;
	private BaseballNumbers baseballNumbers3;
	private BaseballNumbers baseballNumbers4;

	@BeforeEach
	void setIp() {
		rule = Rule.getInstance();
		
		baseballNumbers1 = BaseballNumbersFactory.getInstance().baseballNumbers(123);
		baseballNumbers2 = BaseballNumbersFactory.getInstance().baseballNumbers(123);
		baseballNumbers3 = BaseballNumbersFactory.getInstance().baseballNumbers(321);
		baseballNumbers4 = BaseballNumbersFactory.getInstance().baseballNumbers(789);
	}

	@Test
	@DisplayName("스트라이크 체크로직 테스트")
	void countStrike() {		
		assertThat(rule.countStrike(baseballNumbers1, baseballNumbers2)).isEqualTo(3);
		assertThat(rule.countStrike(baseballNumbers1, baseballNumbers3)).isEqualTo(1);
		assertThat(rule.countStrike(baseballNumbers1, baseballNumbers4)).isEqualTo(0);
		
		assertThat(rule.countStrike(baseballNumbers2, baseballNumbers3)).isEqualTo(1);
		assertThat(rule.countStrike(baseballNumbers2, baseballNumbers4)).isEqualTo(0);
		
		assertThat(rule.countStrike(baseballNumbers3, baseballNumbers4)).isEqualTo(0);
	}

	@Test
	@DisplayName("볼 체크로직 테스트")
	void countBall() {
		assertThat(rule.countBall(baseballNumbers1, baseballNumbers2)).isEqualTo(0);
		assertThat(rule.countBall(baseballNumbers1, baseballNumbers3)).isEqualTo(2);
		assertThat(rule.countBall(baseballNumbers1, baseballNumbers4)).isEqualTo(0);
		
		assertThat(rule.countBall(baseballNumbers2, baseballNumbers3)).isEqualTo(2);
		assertThat(rule.countBall(baseballNumbers2, baseballNumbers4)).isEqualTo(0);
		
		assertThat(rule.countBall(baseballNumbers3, baseballNumbers4)).isEqualTo(0);
	}
	

	@Test
	@DisplayName("삼진 여부 체크로직 테스트")
	void isThreeStrike() {
		assertThat(rule.isThreeStrike(baseballNumbers1, baseballNumbers2)).isTrue();
		assertThat(rule.isThreeStrike(baseballNumbers1, baseballNumbers3)).isFalse();
		assertThat(rule.isThreeStrike(baseballNumbers1, baseballNumbers4)).isFalse();
		
		assertThat(rule.isThreeStrike(baseballNumbers2, baseballNumbers3)).isFalse();
		assertThat(rule.isThreeStrike(baseballNumbers2, baseballNumbers4)).isFalse();
		
		assertThat(rule.isThreeStrike(baseballNumbers3, baseballNumbers4)).isFalse();
	}

	@Test
	@DisplayName("낫싱 여부 체크로직 테스트")
	void isNothing() {
		assertThat(rule.isNothing(baseballNumbers1, baseballNumbers2)).isFalse();
		assertThat(rule.isNothing(baseballNumbers1, baseballNumbers3)).isFalse();
		assertThat(rule.isNothing(baseballNumbers1, baseballNumbers4)).isTrue();
		
		assertThat(rule.isNothing(baseballNumbers2, baseballNumbers3)).isFalse();
		assertThat(rule.isNothing(baseballNumbers2, baseballNumbers4)).isTrue();
		
		assertThat(rule.isNothing(baseballNumbers3, baseballNumbers4)).isTrue();
	}
}
