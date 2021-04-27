package core;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
}
