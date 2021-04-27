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
	
	/* �ʱⰪ ���� */
	public void setInit() {
		Map<Integer, Integer> randomNumber = new LinkedHashMap<Integer, Integer>(); 
		setRandomNumber(randomNumber);
	}
	
	/* �������� ���� */
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
	
	/* ���ӽ��� */
	public void startGame(Map<Integer, Integer> randomScore) {
		String inputString = receiveNumber();
	}
	
	/* ����ڵ����� �Է� */
	public String receiveNumber() {
		System.out.println("���ڸ� �Է����ּ��� : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = "";
		
		try {
			inputString = br.readLine();
			
			while(!validateNumber(inputString)) {
				System.out.println("���ڸ� �Է����ּ��� : ");
				inputString = br.readLine();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return inputString;
	}
	
	/* �Էµ����� ���� */
	public Boolean validateNumber(String input) {
		if (!isNumber(input) || input.length() != 3 || containDupNumber(input)) {
			System.out.println("�Ʒ� ��Ģ�� Ȯ�����ּ���.\r\n1.���ڸ��Է°����մϴ�.\r\n2.3�ڸ��� ���ڸ� �Է��ϼž��մϴ�.\r\n3.1~9���� ���� �ٸ� 3���� ���ڸ� �Է��ϼž� �մϴ�.");
			return false;
		}
		
		return true;
	}
	
	/* �������� ���� */
	public Boolean isNumber(String inputString) {
		try {
			Integer.parseInt(inputString);
			
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	/* �ߺ��� ���� */
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
