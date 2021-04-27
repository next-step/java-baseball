package exam.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballRuleTest {

	@Test
	void testCheckStrike() {
		BaseballRule rule = new BaseballRule("123");
		assertThat(rule.checkStrike("123")).isEqualTo(3);
		assertThat(rule.checkStrike("179")).isEqualTo(1);
		assertThat(rule.checkStrike("129")).isEqualTo(2);
		assertThat(rule.checkStrike("193")).isEqualTo(2);
		assertThat(rule.checkStrike("567")).isEqualTo(0);
	}

	@Test
	void testCheckBall() {
		BaseballRule rule = new BaseballRule("123");
		assertThat(rule.checkBall("123")).isEqualTo(0);
		assertThat(rule.checkBall("312")).isEqualTo(3);
		assertThat(rule.checkBall("278")).isEqualTo(1);
		assertThat(rule.checkBall("239")).isEqualTo(2);
		assertThat(rule.checkBall("318")).isEqualTo(2);
		assertThat(rule.checkBall("567")).isEqualTo(0);
	}

	@Test
	void testEqualToSamePosition() {
		String[] corrects = "123".split("");
		String[] splitted = {"3", "9", "2"};
		BaseballRule rule = new BaseballRule("123");
		assertThat(rule.equalToSamePosition(corrects, splitted, 2))
		.as("check equal seconds position. ").isFalse();

		assertThat(rule.equalToSamePosition(corrects, splitted, 1))
		.as("check not equal first position. ").isFalse();

		assertThat(rule.equalToSamePosition(corrects, splitted, 0))
		.as("check not equal third position. ").isFalse();

		assertThat(rule.equalToSamePosition(corrects, "626".split(""), 1))
		.as("check not equal third position. ").isTrue();
	}

	@Test
	void testContainsOtherPosition() {
		String[] corrects = "123".split("");
		String[] splitted = {"3", "2", "9"};
		BaseballRule rule = new BaseballRule("123");
		assertThat(rule.containsOtherPosition(corrects, splitted, 0))
		.as("check equal seconds position. ").isTrue();

		assertThat(rule.containsOtherPosition(corrects, splitted, 1))
		.as("check equal seconds position. ").isFalse();

		assertThat(rule.containsOtherPosition(corrects, splitted, 2))
		.as("check equal seconds position. ").isFalse();
	}
}
