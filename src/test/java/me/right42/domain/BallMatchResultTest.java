package me.right42.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.right42.domain.type.BallMatchType;

class BallMatchResultTest {

	@Test
	@DisplayName("게임 종료여부 확인 (성공)")
	void gameCompleteTest(){
		BallMatchResult result = new BallMatchResult();

		result.addCount(BallMatchType.STRIKE);
		result.addCount(BallMatchType.STRIKE);
		result.addCount(BallMatchType.STRIKE);

		assertThat(result.isGameComplete()).isTrue();
	}

	@Test
	@DisplayName("게임 종료여부 확인 (실패)")
	void notGameCompleteTest(){
		BallMatchResult result = new BallMatchResult();

		result.addCount(BallMatchType.STRIKE);
		result.addCount(BallMatchType.NOTHING);
		result.addCount(BallMatchType.BALL);

		assertThat(result.isGameComplete()).isFalse();
	}

	@Test
	@DisplayName("스트라이크 수 확인")
	void strikeCount(){
		BallMatchResult result = new BallMatchResult();

		result.addCount(BallMatchType.STRIKE);
		result.addCount(BallMatchType.STRIKE);
		result.addCount(BallMatchType.BALL);

		assertThat(result.getStrikeCount()).isEqualTo(2);
	}

	@Test
	@DisplayName("볼 수 확인")
	void ballCount(){
		BallMatchResult result = new BallMatchResult();

		result.addCount(BallMatchType.BALL);
		result.addCount(BallMatchType.BALL);
		result.addCount(BallMatchType.NOTHING);

		assertThat(result.getBallCount()).isEqualTo(2);
	}

	@Test
	@DisplayName("스트라이크 수 확인")
	void nothingCount(){
		BallMatchResult result = new BallMatchResult();

		result.addCount(BallMatchType.NOTHING);
		result.addCount(BallMatchType.NOTHING);
		result.addCount(BallMatchType.NOTHING);

		assertThat(result.getNothingCount()).isEqualTo(3);
	}
}