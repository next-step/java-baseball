package me.right42.ui;

import java.util.Scanner;

public class InputView {

	public static String inputNumber() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		return scanner.nextLine();
	}

	public static String inputGameContinue() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return scanner.nextLine();
	}
}
