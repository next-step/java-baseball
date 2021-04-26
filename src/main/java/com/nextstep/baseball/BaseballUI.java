package com.nextstep.baseball;

import java.util.Scanner;

public class BaseballUI {
	private Scanner sc;
	public BaseballUI() {
		sc = new Scanner(System.in);
	}
	
	public int getUserBallCount() {
		System.out.println("숫자를입력해주세요:");
		int count = sc.nextInt();
		return count;
	}
	
	public void printResult(String result) {
		System.out.println(result);
	}
	
	public boolean isContinue() {
		System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
		int count = sc.nextInt();
		if(count == 1) {
			return true;
		}
		return false;
	}
}
