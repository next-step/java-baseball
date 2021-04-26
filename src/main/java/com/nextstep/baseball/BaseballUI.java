package com.nextstep.baseball;

import java.util.Scanner;

public class BaseballUI {
	private Scanner sc;
	public BaseballUI() {
		sc = new Scanner(System.in);
	}
	
	public void printToInputNumber() {
		System.out.println("숫자를입력해주세요:");
	}
	
	public int getUserInputNumber() {
		int count = sc.nextInt();
		return count;
	}
}
