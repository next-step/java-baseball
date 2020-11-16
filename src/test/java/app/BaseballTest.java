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


		// when
		GameResult gameResult = baseball.getGameResult(setComNumber(), setUserNumber());

		// then
		assertThat(gameResult).isNotNull();
	}

	@Test
	void judgeNumberTest() {
	}

	@Test
	void isStrikeTest() {
	}

	@Test
	void isBallTest() {
	}

	@Test
	void countJudgeTypeFromJudgeNumberResultList() {
	}
}
