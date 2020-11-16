package com.hoomin.game.baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hoomin.game.baseball.domain.Numbers;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int getGameOption() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public static Numbers getNumbers() {
		System.out.print("숫자를 입력해주세요: ");
		List<Integer> inputNumbers = new ArrayList<>();
		final String s = scanner.nextLine();
		final String[] splitString = s.trim().split("");
		for (String string : splitString) {
			inputNumbers.add(Integer.valueOf(string));
		}
		return new Numbers(inputNumbers);
	}
}
