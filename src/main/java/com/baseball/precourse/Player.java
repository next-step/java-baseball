package com.baseball.precourse;

import java.util.Scanner;

/**
 * @author 김윤제
 *
 */
public class Player {
	private String input;
	
	/*
	 * 플레이어에게 숫자를 입력하게 하는 기능
	 */
	public String selectNums() {
		try {
			System.out.print("숫자를 입력해주세요 : ");
			Scanner sc = new Scanner(System.in);
			input = sc.next();
			sc.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return input;
	}
}
