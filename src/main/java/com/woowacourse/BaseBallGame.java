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
		
		startGame(randomNumber);
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
		
		Map<String, Integer> scores = getScoreCount(randomScore, inputString);
		printScoreMessage(scores.get("strike"), scores.get("ball"));
		
		if (scores.get("strike") == 3) {
			continueGame();
			return;
		}
		
		startGame(randomScore);
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
	
	/* 스트라이크 점수 계산 */
	public int getStrikeCount(Map<Integer, Integer> randomScore, int target, int index) {
		int score = 0;
		
		if (randomScore.containsKey(target) && randomScore.get(target) == index) {
			score += 1;
			return score;
		}
		
		return score;
	}
	
	/* 볼 점수 계산 */
	public int getBallCount(Map<Integer, Integer> randomScore, int target, int index) {
		int score = 0;
		
		if (randomScore.containsKey(target) && randomScore.get(target) != index) {
			score += 1;
			return score;
		}
		
		return score;
	}
	
	/* 결과 출력 */
	public void printScoreMessage(int strikeCnt, int ballCnt) {
		if (strikeCnt == 0 && ballCnt == 0) {
			System.out.println("낫싱");
		}
		
		String answerMsg = (getAnswerMsg(strikeCnt, "S") + " " + getAnswerMsg(ballCnt, "B")).trim();
		System.out.println(answerMsg);
	}
	
	/* 점수별 메세지 반환 */
	public String getAnswerMsg(int num, String dvsCd) {
		String msg = "";
		if (num == 0) return msg;
		
		if (dvsCd == "S") {
			msg = num + " 스트라이크";
			return msg;
		}
		
		return msg = num + " 볼";
	}
	
	/* 게임 시작, 종료 질의 */
	public void continueGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		
		try {
			String cmd = selectCommand();
			
			if ("1".equals(cmd)) {
				setInit();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/* 명령어 선택 */
	public String selectCommand() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cmd = "";
		
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		
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
