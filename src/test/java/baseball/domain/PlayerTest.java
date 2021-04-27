package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.utils.Converter;

public class PlayerTest {
	@Test
	@DisplayName("Strike 여부 판단")
	private void isStrike(int answerNumber, int findNumber) {
		assertEquals(answerNumber, findNumber);
	}

	@Test
	@DisplayName("Strike가 아니라는 전제 하에서 Ball 여부 판단")
	public void isBallWhenDefinitelyNotStrike() {
		List<Integer> answer = new ArrayList<Integer>();
		answer.add(1);
		answer.add(2);
		answer.add(3);

		int findNumber = 3;
		assertThat(answer).contains(findNumber);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3:3 스트라이크", "1,2,4:2 스트라이크", "1,5,4:1 스트라이크",
		"3,2,1:1 스트라이크 2 볼", "4,2,1:1 스트라이크 1 볼",
		"3,1,2:3 볼", "3,5,2:2 볼", "5,6,2:1 볼",
		"4,5,6:낫싱"}, delimiter = ':') //default : ','
	@DisplayName("player의 play에서 나올 수 있는 9가지 경우의 수")
	public void playAnswer(String inputStr, String ExpectedAnswer) {
		Player player = new Player();
		List<Integer> answer = new ArrayList<Integer>();
		answer.add(1);
		answer.add(2);
		answer.add(3);

		List<Integer> inputNumbers = Converter.convertStringToIntegerList(inputStr, ",");
		player.calculate(answer, inputNumbers);
		assertEquals(player.getResult(), ExpectedAnswer);
	}
}
