package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import constants.Result;

class ResultCheckerTest {

	private ResultChecker checker;

	@BeforeEach
	public void setup() {
		checker = new ResultChecker();
	}

	@Test
	public void three_strike_check() {
		BaseballNumber userNumber = new BaseballNumber(1, 2, 3);
		BaseballNumber randomNumber = new BaseballNumber(1, 2, 3);

		checker.checkResult(userNumber, randomNumber);
		assertAll("checker",
			() -> assertEquals(checker.checkResult(userNumber, randomNumber), Result.THREE_STRIKE)
		);
	}

	@Test
	public void three_ball_check() {
		BaseballNumber userNumber = new BaseballNumber(1, 2, 3);
		BaseballNumber randomNumber = new BaseballNumber(3, 1, 2);

		Result result = checker.checkResult(userNumber, randomNumber);
		System.out.println(result.getMessage());

		assertAll("checker",
			() -> assertEquals(checker.checkResult(userNumber, randomNumber), Result.CONTINUE)
		);
	}

	@Test
	public void one_ball_one_strike_check() {
		BaseballNumber userNumber = new BaseballNumber(1, 2, 3);
		BaseballNumber randomNumber = new BaseballNumber(3, 2, 4);

		assertAll("checker",
			() -> assertEquals(checker.checkResult(userNumber, randomNumber), Result.CONTINUE),
			() -> assertEquals(checker.checkResult(userNumber, randomNumber).getMessage(), "1 스트라이크 1 볼")
		);
	}

	@Test
	public void two_ball_one_strike_check() {
		BaseballNumber userNumber = new BaseballNumber(1, 2, 3);
		BaseballNumber randomNumber = new BaseballNumber(3, 2, 1);

		assertAll("checker",
			() -> assertEquals(checker.checkResult(userNumber, randomNumber), Result.CONTINUE),
			() -> assertEquals(checker.checkResult(userNumber, randomNumber).getMessage(), "1 스트라이크 2 볼")
		);
	}

	@Test
	public void noting() {
		BaseballNumber userNumber = new BaseballNumber(4, 5, 6);
		BaseballNumber randomNumber = new BaseballNumber(3, 1, 2);

		checker.checkResult(userNumber, randomNumber);
		assertAll("checker",
			() -> assertEquals(checker.checkResult(userNumber, randomNumber), Result.NOTING)
		);
	}
}
