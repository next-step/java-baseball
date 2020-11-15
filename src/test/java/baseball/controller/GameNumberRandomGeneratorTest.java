package baseball.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Game;
import baseball.domain.GameNumbers;

class GameNumberRandomGeneratorTest {
	@DisplayName("랜덤 넘버 생성 검증")
	@Test
	void generateRandomRightAnswer() throws Exception {
		// Given
		GameNumberRandomGenerator gameNumberRandomGenerator = new GameNumberRandomGenerator();

		// When
		GameNumbers gameNumbers = gameNumberRandomGenerator.generate(3);

		// Then
		int count = 0;
		List<Integer> verificationList = new ArrayList<>();
		for (Integer integer : gameNumbers) {
			assertThat(verificationList).doesNotContain(integer);
			assertThat(integer).isBetween(1, 9);
			verificationList.add(integer);
			count++;
		}
		assertThat(count).isEqualTo(Game.MAX_GAME_NUMBER_LENGTH);
	}
}
