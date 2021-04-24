package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class GameMakerTest {
	private final GameMaker gameMaker;

	GameMakerTest(){
		this.gameMaker = new GameMaker();
	}

	@DisplayName("난수 반복테스트")
	@RepeatedTest(value = 100, name = "{displayName}, {currentRepetitions}/{totalRepetitions}" )
	void generateRandomNumber() {
		System.out.println();
		Set<Integer> numberSet = gameMaker.generateRandomNumber();
		assertThat(numberSet.size()).isEqualTo(3);
		assertThat(numberSet).allMatch(number -> number > 0 && number < 10);
	}
}
