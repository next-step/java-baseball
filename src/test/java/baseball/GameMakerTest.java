package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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

	@DisplayName("플레이어 입력 성공 테스트")
	@Test
	void inputNumber() {
		String input = "123";
		Set<Integer> inputSet = new HashSet<>();
		inputSet.add(1);
		inputSet.add(2);
		inputSet.add(3);

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertThat(gameMaker.inputNumber()).isEqualTo(inputSet);
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
}
