package com.baseball.woowahan;

import static org.assertj.core.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScoreCalculatorAndPrinterTest {
	private int strikeCount;
	private int ballCount;
	private String message;
	private final String RANDOM_NUMBER = "135";

	@BeforeEach
	void init() {
		this.strikeCount = 0;
		this.ballCount = 0;
		this.message = "";
	}

	@DisplayName("문자열 1개 스트라이크 여부")
	@ParameterizedTest
	@CsvSource(value = {"3,1", "4,0", "5,0"}, delimiterString = ",")
	void checkStrikeTest(String input, int strike) {
		checkStrike(1, input);
		assertThat(strikeCount).isEqualTo(strike);
	}

	@DisplayName("문자열 1개 볼 여부")
	@ParameterizedTest
	@CsvSource(value = {"3,0", "1,1", "8,0"}, delimiterString = ",")
	void checkBallTest(String input, int ball) {
		checkBall(1, input);
		assertThat(ballCount).isEqualTo(ball);
	}

	@DisplayName("한 게임의 케이스 별 메시지 확인")
	@ParameterizedTest
	@CsvSource(value = {"142, 1 스트라이크", "235, 2 스트라이크", "325, 1 스트라이크 1 볼", "792, 나싱"})
	void checkMessageTest(String inputNumber, String message) {
		calculate(inputNumber);
		assertThat(this.message.trim()).isEqualTo(message.trim());
	}

	public void calculate(String inputNumber) {

		String[] inputNumbers = inputNumber.split("");
		for (int i = 0; i < GameManager.GAME_LENGTH; i++) {
			checkStrike(i, inputNumbers[i]);
			checkBall(i, inputNumbers[i]);
		}
		setMessage();
	}

	private void setMessage() {

		StringBuilder stringBuilder = new StringBuilder();
		if (strikeCount > 0) {
			stringBuilder.append(strikeCount).append(" ").append(Message.STRIKE.getMessage()).append(" ");
		}
		if (ballCount > 0) {
			stringBuilder.append(ballCount).append(" ").append(Message.BALL.getMessage());
		}
		message = Objects.equals(stringBuilder.length(), 0) ? Message.NOTHING.getMessage() : stringBuilder.toString();
	}

	private void checkStrike(int index, String input) {
		System.out.println(index + "," + RANDOM_NUMBER.indexOf(input));
		if (Objects.equals(index, RANDOM_NUMBER.indexOf(input))) {
			System.out.println(index + "," + RANDOM_NUMBER.indexOf(input));
			strikeCount++;
		}
	}

	private void checkBall(int index, String input) {
		if (!Objects.equals(index, RANDOM_NUMBER.indexOf(input)) && RANDOM_NUMBER.contains(input)) {
			ballCount++;
		}
	}
}
