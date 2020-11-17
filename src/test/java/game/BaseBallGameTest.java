package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
	
}