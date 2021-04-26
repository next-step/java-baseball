package com.precourse.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserScanner {
	private final Scanner sc = new Scanner(System.in);

	/**
	 * 사용자로부터 입력을 받는다.
	 * @return 입력받은 수 반환
	 */
	public List<Integer> scanNumber() {
		String input;
		List<Integer> numberList;
		while (true) {
			input = sc.next();
			try {
				numberList = generateList(input);
				break;
			} catch (RuntimeException re) {
				System.out.print(Constants.INPUT_EXCEPTION_MESSAGE);
			}
		}
		return numberList;
	}

	/**
	 * 입력받은 문자를 저장한 리스트 생성.
	 * @param str : 사용자에게 입력받은 문자열
	 * @return 입력받은 문자를 저장한 List 를 반환
	 */
	public List<Integer> generateList(String str) {
		Set<Integer> numSet = new HashSet<>();
		List<Integer> numList = new ArrayList<>();
		checkLength(str);
		for (char c : str.toCharArray()) {
			int number = charToInt(c);
			numSet.add(number);
			numList.add(number);
		}
		checkUnique(numSet);
		return numList;
	}

	/**
	 * char 형 데이터를 int 형으로 반환
	 */
	public int charToInt(char ch) {
		int number = ch - '0';
		if (number < 1 || number > 9) {
			throw new RuntimeException(Constants.ERR_RANGE_VALUE);
		}
		return number;
	}

	/**
	 * 문자열 길이가 3이 아닐경우 예외발생
	 * @param str : 입력받은 문자열
	 */
	public void checkLength(String str) {
		if (str.length() != Constants.LENGTH_OF_NUMBER) {
			throw new RuntimeException(Constants.ERR_LENGTH_VALUE);
		}
	}

	/**
	 * 중복되는 수가 있을 경우 예외발생
	 * @param numSet : 입력한 수 Set
	 */
	public void checkUnique(Set<Integer> numSet) {
		if (numSet.size() != Constants.LENGTH_OF_NUMBER) {
			throw new RuntimeException(Constants.ERR_DUP_VALUE);
		}
	}

	/**
	 * 1 또는 2가 아닐경우 예외발생
	 * @param input : 메뉴 번호
	 */
	public void checkMenuNum(String input) {
		if (!input.equals("1") && !input.equals("2")) {
			throw new RuntimeException(Constants.ERR_RANGE_VALUE);
		}
	}

	/**
	 * 다시시작 및 종료 선택번호 입력
	 * @return 1 또는 2
	 */
	public String scanMenuNumber() {
		String input;
		while (true) {
			input = sc.next();
			try {
				checkMenuNum(input);
				break;
			} catch (RuntimeException re) {
				System.out.print(Constants.INPUT_EXCEPTION_MESSAGE);
			}
		}
		return input;
	}
}
