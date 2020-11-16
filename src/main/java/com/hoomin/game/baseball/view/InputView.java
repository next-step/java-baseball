package com.hoomin.game.baseball.view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int getGameOption() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Integer.parseInt(scanner.nextLine());
	}
}
