package baseball.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

	private GameService gameService;

	@BeforeEach
	void setUp() {
		gameService = new GameService();
	}

	@Test
	@DisplayName("1~9 서로 다른 3자리 난수 생성")
	void generateNumber() {
		Set<Integer> set = gameService.generateNumber();
		assertThat(set).allMatch(i -> i > 0).hasSize(3);
	}

}