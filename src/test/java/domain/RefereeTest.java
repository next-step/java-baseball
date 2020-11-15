package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.baseballRule.BaseballNumbers;
import domain.baseballRule.BaseballResult;

public class RefereeTest {

	Referee referee = new Referee();

	@DisplayName("Check baseball result is correct")
	@ParameterizedTest
	@CsvSource(value = {"1,2,3,3,0,true", "1,2,4,2,0,false", "3,1,2,0,3,false", "4,5,6,0,0,false"})
	public void checkBaseballResult(Integer firstNumber, Integer secondNumber, Integer thirdNumber, Integer strike, Integer ball, Boolean match) {
		BaseballNumbers opponents = new BaseballNumbers(Arrays.asList(1, 2, 3));
		BaseballNumbers players = new BaseballNumbers(Arrays.asList(firstNumber, secondNumber, thirdNumber));

		BaseballResult baseballResult = referee.checkBaseballResult(players, opponents);

		assertEquals(strike, baseballResult.getStrikeCount());
		assertEquals(ball, baseballResult.getBallCount());
		assertEquals(match, baseballResult.isMatch());
	}

}
