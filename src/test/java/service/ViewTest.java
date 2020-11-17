package service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import vo.GameNumber;
import vo.GameResult;

class ViewTest {

	Baseball baseball = new Baseball();
	View view = new View();

	private GameNumber setComNumber() {
		int[] arr = {1, 2, 3};
		List<Integer> list = new ArrayList<>(arr.length);
		for (int i : arr) {
			list.add(i);
		}
		return new GameNumber(list);
	}

	private GameNumber setUserNumber() {
		int[] arr = {1, 3, 4};
		List<Integer> list = new ArrayList<>(arr.length);
		for (int i : arr) {
			list.add(i);
		}
		return new GameNumber(list);
	}

	@Test
	void gameResultOutputTest() {
		GameResult gameResult = baseball.getGameResult(setComNumber(), setUserNumber());
		view.viewGameResultOutput(gameResult);
	}
}
