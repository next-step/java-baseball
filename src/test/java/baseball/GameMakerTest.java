package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameMakerTest {
	private GameMaker gameMaker;
	private Set<Integer> gameSet;

	@BeforeEach
	void setUp() {
		gameMaker = new GameMaker();
		gameSet = new LinkedHashSet<>();
		gameSet.add(1);
		gameSet.add(2);
		gameSet.add(3);
	}

	@DisplayName("난수 반복테스트")
	@RepeatedTest(value = 100, name = "{displayName}, {currentRepetitions}/{totalRepetitions}" )
	void generateRandomNumber() {
		System.out.println();
		Set<Integer> numberSet = gameMaker.generateRandomNumber();
		assertThat(numberSet.size()).isEqualTo(3);
		assertThat(numberSet).allMatch(number -> number > 0 && number < 10);
	}

	@DisplayName("플레이어 입력 성공 테스트")
	@Test
	void inputNumber() {
		String input = "123";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertThat(gameMaker.inputNumber()).isEqualTo(gameSet);
	}

	@DisplayName("플레이어 입력 유효성 체크 테스트")
	@Test
	void inputNumberValid() {
		List<String> inputList = new ArrayList<>();
		inputList.add("abcde");
		inputList.add("122");
		inputList.add("12345");
		inputList.add("1");
		inputList.add("1.2");
		inputList.add("123.45");

		for(String input : inputList) {
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			assertThatThrownBy(() -> {
				gameMaker.inputNumber();
			}).isInstanceOf(RuntimeException.class);
		}
	}

	@DisplayName("점수 매기기 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1,2,3:3,0",  "1,2,4:2,0", "3,2,1:1,2", "6,7,8:0,0","3,1,2:0,3"}, delimiter = ':')
	void getScore(String playerNumber, String result) {
		String[] playerNumberList = playerNumber.split(",");
		String[] resultList = result.split(",");

		Set<Integer> playerSet = new LinkedHashSet<>();
		for(String s : playerNumberList){
			playerSet.add(Integer.parseInt(s));
		}


		int matchCount = gameMaker.countMatch(gameSet, playerSet);
		int countContain = gameMaker.countContain(gameSet, playerSet);
		int strikeCount = gameMaker.getStrike(matchCount);
		int ballCount = gameMaker.getBall(matchCount, countContain);

		assertThat(strikeCount).isEqualTo(Integer.parseInt(resultList[0]));
		assertThat(ballCount).isEqualTo(Integer.parseInt(resultList[1]));
	}

	@DisplayName("플레이어 승리 판별 테스트")
	@Test
	void getWinner() {
		Set<Integer> playerSet = new LinkedHashSet<>();
		playerSet.add(1);
		playerSet.add(2);
		playerSet.add(3);

		assertThat(gameMaker.getWinner(gameSet, playerSet)).isTrue();

		playerSet.clear();
		playerSet.add(3);
		playerSet.add(6);
		playerSet.add(9);

		assertThat(gameMaker.getWinner(gameSet, playerSet)).isFalse();

		playerSet.clear();
		playerSet.add(3);
		playerSet.add(2);
		playerSet.add(1);

		assertThat(gameMaker.getWinner(gameSet, playerSet)).isFalse();
	}
}
