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
		
		startGame(randomNumber);
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
		
		Map<String, Integer> scores = getScoreCount(randomScore, inputString);
		printScoreMessage(scores.get("strike"), scores.get("ball"));
		
		if (scores.get("strike") == 3) {
			continueGame();
			return;
		}
		
		startGame(randomScore);
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
	
	public Map<String, Integer> getScoreCount(Map<Integer, Integer> randomScore, String inputString) {
		Map<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("strike", 0);
		scores.put("ball", 0);
		
		for (int index = 0; index < inputString.length(); index++) {
			int target = inputString.charAt(index) - '0';
			
			scores.put("strike", scores.getOrDefault("strike", 0) + getStrikeCount(randomScore, target, index));
			scores.put("ball", scores.getOrDefault("ball", 0) + getBallCount(randomScore, target, index));
		}
		
		return scores;
	}
	
	/* ��Ʈ����ũ ���� ��� */
	public int getStrikeCount(Map<Integer, Integer> randomScore, int target, int index) {
		int score = 0;
		
		if (randomScore.containsKey(target) && randomScore.get(target) == index) {
			score += 1;
			return score;
		}
		
		return score;
	}
	
	/* �� ���� ��� */
	public int getBallCount(Map<Integer, Integer> randomScore, int target, int index) {
		int score = 0;
		
		if (randomScore.containsKey(target) && randomScore.get(target) != index) {
			score += 1;
			return score;
		}
		
		return score;
	}
	
	/* ��� ��� */
	public void printScoreMessage(int strikeCnt, int ballCnt) {
		if (strikeCnt == 0 && ballCnt == 0) {
			System.out.println("����");
		}
		
		String answerMsg = (getAnswerMsg(strikeCnt, "S") + " " + getAnswerMsg(ballCnt, "B")).trim();
		System.out.println(answerMsg);
	}
	
	/* ������ �޼��� ��ȯ */
	public String getAnswerMsg(int num, String dvsCd) {
		String msg = "";
		if (num == 0) return msg;
		
		if (dvsCd == "S") {
			msg = num + " ��Ʈ����ũ";
			return msg;
		}
		
		return msg = num + " ��";
	}
	
	/* ���� ����, ���� ���� */
	public void continueGame() {
		System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");
		
		try {
			String cmd = selectCommand();
			
			if ("1".equals(cmd)) {
				setInit();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/* ��ɾ� ���� */
	public String selectCommand() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cmd = "";
		
		System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
		
		try {
			cmd = br.readLine();

			if (!("1".equals(cmd) || "2".equals(cmd))) {
				cmd = selectCommand();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cmd;
	}
}
