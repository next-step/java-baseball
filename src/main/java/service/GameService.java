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
		return Arrays.asList(balls.get(0), balls.get(1), balls.get(2));
	}

	public void start() {
		while (true) {
			run(generate());
			System.out.println(EXIT);
			int input = scanner.nextInt();
			if (!isValidExitInput(input) || input == 2) {
				return;
			}
		}
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
		if (input.length() < 3) {
			throw new BaseballGameException(BAD_INPUT);
		}

		for (int i = 0; i < input.length(); i++) {
			if(!balls.contains(Integer.parseInt(input.substring(i, i+1)))) {
				throw new BaseballGameException(BAD_INPUT);
			}
		}
		return input;
	}

	public void run(List<Integer> generatedBalls) {
		System.out.print(INPUT);
		String input = getRefineInput(scanner.nextLine());
	}
}
