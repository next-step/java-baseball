package baseballgame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefereeTest {
	private Referee referee;
	private List<Integer> answerList;

	@BeforeEach
	void setReferee() {
		answerList = new ArrayList<>();
		answerList.add(1);
		answerList.add(2);
		answerList.add(3);
		referee = new Referee(answerList);
	}

	@Test
	@DisplayName("User 가 입력한 숫자에 맞게 스트라이크 개수가 세어지는지 테스트.")
	void countStrike() {
		int[] userInputArray = {1, 4, 5};
		referee.getJudgeResult(userInputArray);
		assertEquals(referee.getStrikeCount(), 1);
	}

	@Test
	@DisplayName("User 가 입력한 숫자에 맞게 볼 개수가 세어지는지 테스트.")
	void countBall() {
		int[] userInputArray = {3, 4, 5};
		referee.getJudgeResult(userInputArray);
		assertEquals(referee.getBallCount(), 1);
	}

	@Test
	@DisplayName("User 가 입력한 숫자에 스트라이크와, 볼이 없으면 낫싱인지 테스트.")
	void isZeroStrikeAndBallThenNothing() {
		int[] userInputArray = {5, 6, 7};
		referee.getJudgeResult(userInputArray);
		assertEquals(referee.getStrikeCount() + referee.getBallCount(), 0);
	}
}
