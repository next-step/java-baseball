package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import utils.StringUtil;

public class BaseballTest {
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	@DisplayName("1~9까지 서로 다른 수로 이루어진 3자리 수 생성")
	void baseball() {
		Baseball baseball = new Baseball();
		List<Integer> answerNumbers = baseball.answerNumbers;
		assertThat(answerNumbers).hasSize(3);

		HashSet<Integer> uniqueSet = new HashSet<>(answerNumbers);
		assertThat(uniqueSet).hasSize(3);

		for(Integer number: answerNumbers) {
			assertThat(number).isIn(1, 2, 3, 4, 5, 6, 7, 8, 9);
		}
	}

	@ParameterizedTest
	@CsvSource(value={
		"1,2,3:1,2,3:true",
		"1,2,3:1,3,2:false",
		"1,2,3:2,1,3:false",
		"1,2,3:2,3,1:false",
		"1,2,3:3,1,2:false",
		"1,2,3:3,2,1:false",
		"1,2,3:4,5,6:false"
	}, delimiter=':')
	@DisplayName("정답과 입력값 비교, 볼카운트를 판정하여 정답여부 확인")
	void checkAnswer(String answer, String input, Boolean isCorrectAnswer) {
		Baseball baseball = new Baseball();
		List<Integer> answerNumberList = StringUtil.stringToIntegerListWithDelimiter(answer);
		baseball.setAnswerNumbers(answerNumberList);
		List<Integer> inputNumberList = StringUtil.stringToIntegerListWithDelimiter(input);
		assertThat(baseball.checkAnswer(inputNumberList)).isEqualTo(isCorrectAnswer);
	}

	@ParameterizedTest
	@CsvSource(value={
		"1,2,3:1,2,3:3 스트라이크",
		"1,2,3:1,3,2:1 스트라이크 2볼",
		"1,2,3:2,1,3:1 스트라이크 2볼",
		"1,2,3:2,3,1:3볼",
		"1,2,3:3,1,2:3볼",
		"1,2,3:3,2,1:1 스트라이크 2볼",
		"1,2,3:4,5,6:낫싱"
	}, delimiter=':')
	@DisplayName("정답과 입력값 비교, 볼카운트를 판정하여 System.out 출력")
	void printBallCount(String answer, String input, String message) {
		Baseball baseball = new Baseball();
		List<Integer> answerNumberList = StringUtil.stringToIntegerListWithDelimiter(answer);
		baseball.setAnswerNumbers(answerNumberList);
		List<Integer> inputNumberList = StringUtil.stringToIntegerListWithDelimiter(input);
		baseball.checkAnswer(inputNumberList);
		baseball.printBallCount();
		assertThat(message).isEqualTo(outputStreamCaptor.toString().trim());
	}
}
