package com.hoomin.game.baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hoomin.game.baseball.domain.Numbers;
import com.hoomin.game.baseball.enums.GameOption;

/**
 * 비즈니스 로직 없이 입력을 담당한다.
 */
public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static GameOption getGameOption() {
		System.out.println("게임을 새로 시작하려면 'RESTART', 종료하려면 'QUIT'를 입력하세요.");
		return GameOption.valueOf(scanner.nextLine().toUpperCase());
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
