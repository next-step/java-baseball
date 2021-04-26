package com.precourse.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserScanner {
	private final Scanner sc = new Scanner(System.in);

	/**
	 * 사용자로부터 입력을 받는다.
	 * @return 입력받은 수 반환
	 */
	public List<Integer> scanNumber() {
		List<Integer> numberList;
		String input = sc.next();
		numberList = generateList(input);
		return numberList;
	}

	/**
	 * 입력받은 문자를 저장한 리스트 생성.
	 * @param str : 사용자에게 입력받은 문자열
	 * @return 입력받은 문자를 저장한 List 를 반환
	 */
	public List<Integer> generateList(String str) {
		List<Integer> numList = new ArrayList<>();
		for (char c : str.toCharArray()) {
			int number = charToInt(c);
			numList.add(number);
		}
		return numList;
	}

	/**
	 * char 형 데이터를 int 형으로 반환
	 */
	public int charToInt(char ch) {
		return ch - '0';
	}
}
