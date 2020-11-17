package io.chikeem90.github.service;

import java.util.Scanner;

import io.chikeem90.github.domain.BaseballCount;

public class InOutputUtil {
	private static final Scanner sc = new Scanner(System.in);
	public static String initInputNumber() {
		String input;
		do {
			printNumberInputMsg();
			input = sc.next();
		} while (!CommonUtil.isValid(input));
		return input;
	}

	public static void printNumberInputMsg() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public static void notNumberInputMsg() {
		System.out.println("1에서 9사이 숫자를 입력해주세요.");
	}

	public static void invalidLengthInputMsg() {
		System.out.println("3자리가 아닙니다. 다시 입력해주세요.");
	}

	public static void duplicatedInputMsg() {
		System.out.println("중복 숫자 없이 입력해주세요.");
	}

	public static void invalidOptionValMsg() {
		System.out.println("1 또는 2를 입력해주세요.");
	}

	public static void printResult(BaseballCount baseballCount) {
		if (baseballCount.isNoting()) {
			System.out.println("낫싱");
			return;
		}
		System.out.println(getInfoMsg(baseballCount));
	}

	private static String getInfoMsg(BaseballCount baseballCount) {
		StringBuffer sb = new StringBuffer();
		getStrikeMsg(baseballCount, sb);
		getBallMsg(baseballCount, sb);
		getThreeStrikeMsg(baseballCount, sb);
		return sb.toString();
	}

	private static void getStrikeMsg(BaseballCount baseballCount, StringBuffer sb) {
		int strike = baseballCount.getStrikeCount();
		if (strike > 0) {
			sb.append(strike).append(" 스트라이크 ");
		}
	}

	private static void getBallMsg(BaseballCount baseballCount, StringBuffer sb) {
		int ball = baseballCount.getBallCount();
		if (ball > 0) {
			sb.append(ball).append(" 볼 ");
		}
	}

	private static void getThreeStrikeMsg(BaseballCount baseballCount, StringBuffer sb) {
		int strike = baseballCount.getStrikeCount();
		if (strike == 3) {
			sb.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	}

	public static String getOptionVal() {
		System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
		String option;
		do {
			option = sc.next();
		} while (!CommonUtil.isValidInput(option));
		return option;
	}
}
