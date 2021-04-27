package core;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.w3c.dom.ranges.RangeException;

import baseballgame.GameStarter;
import baseballgame.ResultReader;

public class CoreTest {
	GameStarter gameStarter = new GameStarter();
	ResultReader resultReader = new ResultReader();

	@Test
	public void number_duplication_test() {
		int count = 0;
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Random answerNumber = new Random();
		Set<Integer> deduplicationAnswerNumber = new HashSet<Integer>();
		while (deduplicationAnswerNumber.size() < 3) {
			deduplicationAnswerNumber.add(answerNumber.nextInt(8) + 1);
		}

		for (int i = 0; i < answer.size(); i++) {
			if (answer.contains(answer.get(i))) {
				count++;
			}
		}
		assertEquals(0, count);
	}

	@ValueSource(strings = "12345")
	@ParameterizedTest
	public void number_of_digit_test(String input) {
		String[] splitInput = input.split("{1}");

		assertThatThrownBy(() -> {
			gameStarter.processInput(splitInput);
		})
			.isInstanceOf(RangeException.class);
	}

	@CsvSource({"123,563"})
	@ParameterizedTest
	public void index_duplication_test(String answer, String userInput) {
		int count = 0;
		String[] answerArray = answer.split("{1}");
		String[] userInputArray = userInput.split("{1}");
		for (int i = 0; i < 3; i++) {
			int answerCurrentNumber = Integer.parseInt(answerArray[i]);
			int userCurrentNumber = Integer.parseInt(userInputArray[i]);
			if (answerCurrentNumber == userCurrentNumber) {
				count++;
			}
		}
		assertEquals(1, count);
	}

	@CsvSource({"321,53"})
	@ParameterizedTest
	public void number_contain_test(String answer, String userInput) {
		int count = 0;
		String[] splitAnswer = answer.split("{1}");
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			answerList.add(Integer.parseInt(splitAnswer[i]));
		}

		String[] userInputArray = userInput.split("{1}");
		for (int i = 0; i < userInputArray.length; i++) {
			if (answerList.contains(Integer.parseInt(userInputArray[i]))) {
				count++;
			}
		}
		assertEquals(1, count);
	}

	@CsvSource({"321,531"})
	@ParameterizedTest
	public void result_validation_test(String rawAnswer, String rawUserInput) {
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		ArrayList<Integer> userInfoList = new ArrayList<Integer>();
		String[] splitAnswer = rawAnswer.split("{1}");
		String[] splitUserInfo = rawUserInput.split("{1}");

		for (int i = 0; i < 3; i++) {
			answerList.add(Integer.parseInt(splitAnswer[i]));
			userInfoList.add(Integer.parseInt(splitUserInfo[i]));
		}

		StringBuilder result = resultReader.deriveResult(answerList, userInfoList);
		assertEquals("1 스트라이크 1 볼", result.toString());
	}
}
