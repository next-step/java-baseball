package service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import constant.GameConstant;
import exception.BaseballGameException;

public class GameService implements GameConstant {

	private List<Integer> balls;
	private Scanner scanner;

	public GameService() {
		this.balls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		this.scanner = new Scanner(System.in);
	}

	public List<Integer> generate() {
		Collections.shuffle(balls);
		System.out.println(balls.get(0) + " " + balls.get(1) + " " + balls.get(2));
		return Arrays.asList(balls.get(0), balls.get(1), balls.get(2));
	}

	public void start() {
		do {
			run(generate());
		} while (!exit());
	}

	public boolean exit() {
		System.out.println(EXIT);
		int input = Integer.parseInt(scanner.nextLine());
		return !isValidExitInput(input) || input == 2;
	}

	public boolean isValidExitInput(int input) {
		if (input != 1 && input != 2) {
			System.out.println(BAD_INPUT);
			return false;
		}
		return true;
	}

	public String getRefineInput(String input) {
		input = input.replaceAll(" ", "");
		if (input.length() < 1) {
			throw new BaseballGameException(BAD_INPUT);
		}

		for (int i = 0; i < input.length(); i++) {
			validateInputNumber(input, i);
		}
		return input;
	}

	private void validateInputNumber(String input, int idx) {
		if (!balls.contains(Integer.parseInt(input.substring(idx, idx + 1))) || input.length() > 3) {
			throw new BaseballGameException(BAD_INPUT);
		}
	}

	public void run(List<Integer> generatedBalls) {
		String input = "";
		do {
			input = inputNumber();
			checkStrike(generatedBalls, input);
			checkBall(generatedBalls, input);
			checkNothing(generatedBalls, input);
			System.out.println();
		} while (getStrikeCount(generatedBalls, input) != 3);
	}

	public String inputNumber() {
		System.out.print(INPUT);
		return getRefineInput(scanner.nextLine());
	}

	public void checkStrike(List<Integer> balls, String input) {
		int count = getStrikeCount(balls, input);
		if (count != 0) {
			System.out.print(count + STRIKE);
		}
	}

	public int getStrikeCount(List<Integer> balls, String input) {
		int count = 0;
		for (int i = 0; i < balls.size(); i++) {
			count += getMatchCount(balls, input, i);
		}
		return count;
	}

	private int getMatchCount(List<Integer> balls, String input, int idx) {
		return balls.get(idx) == Integer.parseInt(input.substring(idx, idx + 1)) ? 1 : 0;
	}

	public void checkBall(List<Integer> balls, String input) {
		int count = getBallCount(balls, input);
		if (count > 0) {
			System.out.print(count + BALL);
		}
	}

	public int getBallCount(List<Integer> balls, String input) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			count += getContainsCount(balls, input, i);
		}
		return count -= getStrikeCount(balls, input);
	}

	private int getContainsCount(List<Integer> balls, String input, int idx) {
		return balls.contains(Integer.parseInt(input.substring(idx, idx + 1))) ? 1 : 0;
	}

	public void checkNothing(List<Integer> balls, String input) {
		if (getStrikeCount(balls, input) == 0 && getBallCount(balls, input) == 0) {
			System.out.print(NOTHING);
		}
	}
}
