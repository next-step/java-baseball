package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class ComputerTest {

	@RepeatedTest(10)
	void chooseNumbers() {
		int numberLength = 3;
		Computer computer = new Computer(numberLength);
		int[] answer = computer.chooseNumbers();
		boolean isDuplicated = isDuplicated(answer);

		assertEquals(numberLength, answer.length);
		assertFalse(isDuplicated);
	}

	@ParameterizedTest
	@CsvSource(
		value = {
			"3:7,1,3:1,2,3:1:1",
			"3:7,1,3:1,4,5:0:1",
			"3:7,1,3:6,7,1:0:2",
			"3:7,1,3:2,1,6:1:0",
			"3:7,1,3:7,1,3:3:0",
		},
		delimiter = ':'
	)
	void judge(
		int numberLength,
		@ConvertWith(IntArrayConverter.class) int[] guess,
		@ConvertWith(IntArrayConverter.class) int[] answer,
		int expectedStrikeCount,
		int expectedBallCount
	) {
		Computer computer = new Computer(numberLength);
		Judgement actual = computer.judge(guess, answer);
		Judgement expected = new Judgement.Builder(numberLength, expectedStrikeCount, expectedBallCount).build();

		assertEquals(expected, actual);
	}

	private boolean isDuplicated(int[] numbers) {
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();

		for (int number : numbers) {
			list.add(number);
			set.add(number);
		}

		return list.size() != set.size();
	}
}