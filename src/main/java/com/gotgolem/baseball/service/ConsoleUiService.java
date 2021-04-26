package com.gotgolem.baseball.service;

import java.util.Scanner;

public class ConsoleUiService {

	private final Scanner scanner;

	public ConsoleUiService() {
		scanner = new Scanner(System.in);
	}

	public String requestPitches() {
		System.out.print("숫자를 입력해주세요 : ");
		return scanner.nextLine();
	}

	public String requestContinue() {
		// 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return scanner.nextLine();
	}

	public void printEnding() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void printPitchHint(int strikeCount, int ballCount) {
		if (strikeCount == 0 && ballCount == 0) {
			System.out.println("낫싱");
		}
		final String strikeMessage = strikeCount > 0 ? (strikeCount + "스트라이크 ") : "";
		final String ballMessage = ballCount > 0 ? (ballCount + "볼") : "";
		System.out.println(strikeMessage + ballMessage);
	}

}
