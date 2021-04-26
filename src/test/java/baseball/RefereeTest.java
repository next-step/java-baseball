package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RefereeTest {

	List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
	List<Integer> opponentNumbers = new ArrayList<>(Arrays.asList(1, 3, 9));

	@DisplayName("두 리스트 중 인덱스와 값이 같은 요소 개수")
	@Test
	void countEquals() {
		List<Integer> copy = playerNumbers;
		assertThat(Referee.countEquals(playerNumbers.iterator(), copy.iterator())).isEqualTo(3);
		assertThat(Referee.countEquals(playerNumbers.iterator(), opponentNumbers.iterator())).isEqualTo(1);
	}

	@DisplayName("스트라이크 계산")
	@Test
	void countStrikes() {
		Deck playerDeck = Deck.createCustomDeck(playerNumbers);
		Deck copyDeck = Deck.createCustomDeck(playerNumbers);
		Deck opponentDeck = Deck.createCustomDeck(opponentNumbers);

		assertThat(Referee.countStrikes(playerDeck, copyDeck)).isEqualTo(3);
		assertThat(Referee.countStrikes(playerDeck, opponentDeck)).isEqualTo(1);
	}

	@DisplayName("볼 계산")
	@Test
	void countBalls() {
		Deck playerDeck = Deck.createCustomDeck(playerNumbers);
		Deck copyDeck = Deck.createCustomDeck(playerNumbers);
		Deck opponentDeck = Deck.createCustomDeck(opponentNumbers);

		assertThat(Referee.countBalls(playerDeck, copyDeck)).isEqualTo(0);
		assertThat(Referee.countBalls(playerDeck, opponentDeck)).isEqualTo(1);
	}

	@DisplayName("정답: 스트라이크 3")
	@Test
	void isAnswer() {
		assertThat(Referee.isAnswer(Deck.SIZE)).isTrue();
	}

	@DisplayName("낫싱: 스트라이크 0, 볼 0")
	@Test
	void isNothing() {
		assertThat(Referee.isNothing(0, 0)).isTrue();
	}

}
