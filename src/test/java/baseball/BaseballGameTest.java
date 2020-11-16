package baseball;

import java.util.Scanner;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;

class BaseballGameTest {

	private static Scanner scanner;
	@Resource
	private BaseballGame__ baseballGame;

	@Test
	void main() {

	}

	@Test
	void makeBaseballGoal() {

		Integer[] data = BaseballGame__.getBaseballGoalNumber();

		printArray(data);
	}

	public void printArray(Object[] arr) {

		for (Object obj : arr) {
			System.out.println(obj.toString());
		}
	}
}
