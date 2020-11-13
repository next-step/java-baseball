package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author : byungkyu
 * @date : 2020/11/13
 * @description : 점수기능 테스트
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ScoreTest {

	@Order(1)
	@Test
	@DisplayName("3.1.1.상대방이_숫자를_판단한다/볼일경우_볼_카운트가_증가")
	void addBall() {
		Score score = new Score();

		score.addBall();

		assertEquals(score.getBall(), 1);
	}

	@Order(2)
	@Test
	@DisplayName("3.1.2.상대방이_숫자를_판단한다/스트라이크일경우_스트라이크_카운트가_증가")
	void addStrike() {
		Score score = new Score();

		score.addStrike();

		assertEquals(score.getStrike(), 1);
	}

	@Order(3)
	@Test
	@DisplayName("3.1.3.상대방이_숫자를_판단한다/3번의_스트라이크일경우_전체가_스트라이크")
	void isAllStrike() {
		Score score = new Score();

		score.addStrike();
		score.addStrike();
		score.addStrike();

		assertTrue(score.isAllStrike());
	}

	@Order(4)
	@Test
	@DisplayName("3.1.4.상대방이_숫자를_판단한다/볼일경우_볼_카운트가_증가")
	void isNotAllStrike() {
		Score score = new Score();

		score.addStrike();
		score.addStrike();
		score.addBall();

		assertFalse(score.isAllStrike());
	}

	@Order(5)
	@Test
	@DisplayName("3.1.5.상대방이_숫자를_판단한다/볼이나_스트라이크가_없는_경우_낫싱")
	void isNothing() {
		Score score = new Score();

		assertTrue(score.isNothing());
	}

}