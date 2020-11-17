package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BaseBallGameTest {
	
	BaseballGame game = new BaseballGame();

	@DisplayName("랜덤숫자 만들기")
	@RepeatedTest(value = 30, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
	void makeAnswerNumber() {
		int[] answer = game.makeAnswerNumber();
		System.out.println("### 정답 : " + answer[0] + answer[1] + answer[2]);
	}
	
	@DisplayName("숫자 - 숫자 아닌 값 확인")
	@ParameterizedTest
	@ValueSource(strings = {"afcf", "df123", " ", "-_-", "aber1a"})
	void checkNumberType(String data) {
		Throwable thrown = assertThrows(RuntimeException.class, () -> {
			game.verifyInputNumber(data).toString();
		});
		assertTrue(thrown.getMessage().contains("숫자가 아닙니다"));
	}
	
	@DisplayName("숫자 - 0 포함여부 확인")
	@ParameterizedTest
	@ValueSource(strings = {"011", "780", "600", "0", "007"})
	void containZeroValue(String data) {
		
		Throwable thrown = assertThrows(RuntimeException.class, () -> {
			game.verifyInputNumber(data).toString();
		});
		assertTrue(thrown.getMessage().contains("0이 포함"));
	}
	
	@DisplayName("숫자 - 자리수 확인")
	@ParameterizedTest
	@ValueSource(strings = {"51", "8", "2316", "79114", "72"})
	void checkInputLength(String data) {
		
		Throwable thrown = assertThrows(RuntimeException.class, () -> {
			game.verifyInputNumber(data).toString();
		});
		assertTrue(thrown.getMessage().contains("3자리 숫자"));
	}
	
	@DisplayName("숫자 - 중복숫자 확인")
	@ParameterizedTest
	@ValueSource(strings = {"155", "828", "336", "855", "414"})
	void isUniqueValue(String data) {
		
		Throwable thrown = assertThrows(RuntimeException.class, () -> {
			game.verifyInputNumber(data).toString();
		});
		assertTrue(thrown.getMessage().contains("중복된 숫자"));
	}
	
}
