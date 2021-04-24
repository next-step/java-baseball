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
		checkStrike(RANDOM_NUMBER, 1, input);
		assertThat(strikeCount).isEqualTo(strike);
	}

	@DisplayName("문자열 1개 볼 여부")
	@ParameterizedTest
	@CsvSource(value = {"3,0", "1,1", "8,0"}, delimiterString = ",")
	void checkBallTest(String input, int ball) {
		checkBall(RANDOM_NUMBER, 1, input);
		assertThat(ballCount).isEqualTo(ball);
	}

	@DisplayName("한 게임의 케이스 별 메시지 확인")
	@ParameterizedTest
	@CsvSource(value = {"142, 1 스트라이크", "235, 2 스트라이크", "325, 1 스트라이크 1 볼", "792, 나싱"})
	void checkMessageTest(String inputNumber, String message) {
		calculate(inputNumber, RANDOM_NUMBER);
		assertThat(this.message.trim()).isEqualTo(message.trim());
	}

	public void calculate(String inputNumber, String randomNumber) {

		String[] inputNumbers = inputNumber.split("");
		for (int i = 0; i < GameManager.GAME_LENGTH; i++) {
			checkStrike(randomNumber, i, inputNumbers[i]);
			checkBall(randomNumber, i, inputNumbers[i]);
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

	private void checkStrike(String randomNumber, int index, String input) {
		System.out.println(index + "," + randomNumber.indexOf(input));
		if (Objects.equals(index, randomNumber.indexOf(input))) {
			System.out.println(index + "," + randomNumber.indexOf(input));
			strikeCount++;
		}
	}

	private void checkBall(String randomNumber, int index, String input) {
		if (!Objects.equals(index, randomNumber.indexOf(input)) && randomNumber.contains(input)) {
			ballCount++;
		}
	}
}
