package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GameTest {

	Game game;

	@BeforeEach
	void setUp() {
		game = new Game();
	}

	@DisplayName("플레이어 생성")
	@Test
	void createPlayer() {
		assertThat(game.getPlayer()).isNull();

		List<Integer> origin = Arrays.asList(1, 2, 3);
		Deck deck = Deck.createCustomDeck(origin);
		game.createPlayer(deck.numbers());

		assertThat(game.getPlayer().numbers()).isEqualTo(origin);
	}

	@DisplayName("상대방 생성")
	@Test
	void createOpponent() {
		assertThat(game.getOpponent()).isNull();
		game.createOpponent();
		assertThat(game.getOpponent()).isNotNull();
	}

}
