package org.dhlee.game.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayResultTest {
	PlayResult playResult = new PlayResult(2, 1);

	@Test
	@DisplayName("스트라이크 갯수 비교 테스트")
	public void getPlayResultTest() {
		assertThat(playResult.getPlayResult(2)).isEqualTo(true);
		assertThat(playResult.getPlayResult(3)).isEqualTo(false);
	}
}
