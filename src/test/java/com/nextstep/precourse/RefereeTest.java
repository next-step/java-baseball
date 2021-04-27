package com.nextstep.precourse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.nextstep.precourse.computer.BaseBallResult;
import com.nextstep.precourse.computer.Referee;

public class RefereeTest {
	private Referee referee;
	private List<Integer> answerList;

	@BeforeEach
	void setReferee() {
		answerList = new ArrayList<>();
		answerList.add(1);
		answerList.add(2);
		answerList.add(3);
		referee = new Referee();
	}

	@ParameterizedTest
	@CsvSource(value = {"134:1", "124:2", "123:3", "143:2", "423:2"}, delimiter = ':')
	@DisplayName("User 가 입력한 숫자에 맞게 스트라이크 개수가 세어지는지 테스트.")
	void countStrike(String input, int expected) {
		BaseBallResult baseBallResult = referee.getResult(answerList, input);
		assertEquals(baseBallResult.getStrikeCount(), expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"345:1", "451:1", "321:2", "312:3", "456:0"}, delimiter = ':')
	@DisplayName("User 가 입력한 숫자에 맞게 볼 개수가 세어지는지 테스트.")
	void countBall(String input, int expected) {
		BaseBallResult baseBallResult = referee.getResult(answerList, input);
		assertEquals(baseBallResult.getBallCount(), expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"456:true", "145:false", "789:true", "387:false"}, delimiter = ':')
	@DisplayName("User 가 입력한 숫자에 스트라이크와, 볼이 없으면 낫싱인지 테스트.")
	void isZeroStrikeAndBallThenNothing(String input, boolean expected) {
		BaseBallResult baseBallResult = referee.getResult(answerList, input);
		assertEquals(baseBallResult.isNothing(), expected);
	}
}
