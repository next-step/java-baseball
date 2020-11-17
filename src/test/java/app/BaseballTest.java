package app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

class BaseballTest {

	@Resource
	Baseball baseball = new Baseball();

	private GameNumber setComNumber() {
		GameNumber comNumber = new GameNumber();
		int[] arr = {1, 2, 3};
		ArrayList<Integer> list = new ArrayList<Integer>(arr.length);
		for (int i : arr) {
			list.add(i);
		}
		comNumber.setGameNumberList(list);
		return comNumber;
	}

	private GameNumber setUserNumber() {
		GameNumber userNumber = new GameNumber();
		int[] arr = {1, 3, 4};
		ArrayList<Integer> list = new ArrayList<Integer>(arr.length);
		for (int i : arr) {
			list.add(i);
		}
		userNumber.setGameNumberList(list);
		return userNumber;
	}

	@Test
	@RepeatedTest(500)
	void createRandomGameNumberTest() {
		// given

		// when
		GameNumber randomGameNumber = baseball.createRandomGameNumber();

		// then
		assertThat(Integer.parseInt(randomGameNumber.toString())).isBetween(123, 987);
		assertThat(new HashSet<>(randomGameNumber.getGameNumberList()).size()).isEqualTo(3);
	}

	@Test
	void convertNumberStringToGameNumberTest() {
		// given
		String numberString = "123";

		// when
		GameNumber gameNumber = baseball.convertNumberStringToGameNumber(numberString);

		// then
		assertThat(gameNumber.getGameNumberList().size()).isEqualTo(3);
		assertThat(gameNumber.getGameNumberList().get(0)).isEqualTo(1);
		assertThat(gameNumber.getGameNumberList().get(1)).isEqualTo(2);
		assertThat(gameNumber.getGameNumberList().get(2)).isEqualTo(3);
	}


	@Test
	void getGameResultTest() {
		// given
		GameNumber comNumber = setComNumber();
		GameNumber userNumber = setUserNumber();

		// when
		GameResult gameResult = baseball.getGameResult(comNumber, userNumber);

		// then
		assertThat(gameResult.getStrikeCount()).isEqualTo(1);
		assertThat(gameResult.getBallCount()).isEqualTo(1);
		assertThat(gameResult.getNothingCount()).isEqualTo(1);
	}

	@Test
	void judgeNumberTest() {
		// given
		GameNumber comNumber = setComNumber();
		GameNumber userNumber = setUserNumber();

		// when
		String judgeNumber1 = baseball.judgeNumber(comNumber, userNumber, 0);
		String judgeNumber2 = baseball.judgeNumber(comNumber, userNumber, 1);
		String judgeNumber3 = baseball.judgeNumber(comNumber, userNumber, 2);

		// then
		assertThat(judgeNumber1).isEqualTo(JudgeType.STRIKE.name());
		assertThat(judgeNumber2).isEqualTo(JudgeType.BALL.name());
		assertThat(judgeNumber3).isEqualTo(JudgeType.NOTHING.name());

	}

	@Test
	void isStrikeTest() {
		// given
		GameNumber comNumber = setComNumber();
		GameNumber userNumber = setUserNumber();

		// when
		boolean test1 = baseball.isStrike(comNumber, userNumber, 0);
		boolean test2 = baseball.isStrike(comNumber, userNumber, 1);
		boolean test3 = baseball.isStrike(comNumber, userNumber, 2);

		// then
		assertThat(test1).isTrue();
		assertThat(test2).isFalse();
		assertThat(test3).isFalse();
	}

	@Test
	void isBallTest() {
		// given
		GameNumber comNumber = setComNumber();
		GameNumber userNumber = setUserNumber();

		boolean test1 = baseball.isBall(comNumber, userNumber, 0);
		boolean test2 = baseball.isBall(comNumber, userNumber, 1);
		boolean test3 = baseball.isBall(comNumber, userNumber, 2);

		// then
		assertThat(test1).isFalse();
		assertThat(test2).isTrue();
		assertThat(test3).isFalse();
	}

	@Test
	void countJudgeTypeFromJudgeNumberResultList() {
		// given
		ArrayList<String> judgeNumberResultList = new ArrayList<>();
		judgeNumberResultList.add(JudgeType.STRIKE.name());
		judgeNumberResultList.add(JudgeType.STRIKE.name());
		judgeNumberResultList.add(JudgeType.STRIKE.name());
		judgeNumberResultList.add(JudgeType.BALL.name());
		judgeNumberResultList.add(JudgeType.BALL.name());
		judgeNumberResultList.add(JudgeType.NOTHING.name());

		// when
		GameResult gameResult = baseball.countJudgeTypeFromJudgeNumberResultList(judgeNumberResultList);

		// then
		assertThat(gameResult.getStrikeCount()).isEqualTo(3);
		assertThat(gameResult.getBallCount()).isEqualTo(2);
		assertThat(gameResult.getNothingCount()).isEqualTo(1);
	}
}
