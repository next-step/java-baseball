package com.woowacourse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class BaseBallGame {
	public static void main(String[] args) {
		BaseBallGame baseBallGame = new BaseBallGame();
		baseBallGame.setInit();
	}
	
	/* 초기값 설정 */
	public void setInit() {
		Map<Integer, Integer> randomNumber = new LinkedHashMap<Integer, Integer>(); 
		setRandomNumber(randomNumber);
	}
	
	/* 랜덤숫자 생성 */
	public void setRandomNumber(Map<Integer, Integer> randomNumber) {
		if (randomNumber.size() == 3) {
			return;
		}
		
		Random randomNum = new Random();
		int num = (int)(randomNum.nextInt(9)) + 1;
		
		if (!randomNumber.containsKey(num)) {
			randomNumber.put(num, randomNumber.size());
		}

		setRandomNumber(randomNumber);
	}
	
	/* 게임시작 */
	public void startGame(Map<Integer, Integer> randomScore) {
		String inputString = receiveNumber();
	}
	
	/* 사용자데이터 입력 */
	public String receiveNumber() {
		System.out.println("숫자를 입력해주세요 : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = "";
		
		try {
			inputString = br.readLine();
			
			while(!validateNumber(inputString)) {
				System.out.println("숫자를 입력해주세요 : ");
				inputString = br.readLine();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return inputString;
	}
	
	/* 입력데이터 검증 */
	public Boolean validateNumber(String input) {
		if (!isNumber(input) || input.length() != 3 || containDupNumber(input)) {
			System.out.println("아래 규칙을 확인해주세요.\r\n1.숫자만입력가능합니다.\r\n2.3자리의 숫자를 입력하셔야합니다.\r\n3.1~9까지 서로 다른 3가지 숫자를 입력하셔야 합니다.");
			return false;
		}
		
		return true;
	}
	
	/* 숫자인지 검증 */
	public Boolean isNumber(String inputString) {
		try {
			Integer.parseInt(inputString);
			
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	/* 중복값 검증 */
	public Boolean containDupNumber(String inputString) {
		HashSet<Character> numbers = new HashSet<Character>();
		
		for (int i = 0; i < inputString.length(); i++) {
			char temp = inputString.charAt(i);
			
			if (numbers.contains(temp)) {
				return true; 
			}
			
			numbers.add(temp);
		}
		
		return false;
	}
}
