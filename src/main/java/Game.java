
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import type.GameStatus;

public class Game {
	private static String START_MESSAGE = "게임을 시작합니다.";
	private static String QUESTION_MESSAGE = "숫자를 입력해주세요 : ";
	
	private Scanner scanner;

	private GameStatus gameStatus = GameStatus.IN_PROGRESS;

	private List<Integer> targetNumber;
	
	public void playRound() {
		System.out.println(START_MESSAGE);

		generateTargetNumber();
		
		inputAnswer();
	}
	
	private void generateTargetNumber() {
		Set<Integer> numbers = getTargetNumberSet();
		
		targetNumber = new ArrayList<Integer>();
		for (int number : numbers) {
			targetNumber.add(number);
		}
	}
	
	public Set<Integer> getTargetNumberSet() {
		Set<Integer> numbers = new LinkedHashSet<>();
		
		while (numbers.size() < 3) {
			numbers.add((int)(Math.random() * 9) + 1);
		}
		
		return numbers;	
	}
	
	private void inputAnswer() {
		while (gameStatus.equals(GameStatus.IN_PROGRESS) || gameStatus.equals(GameStatus.WAITING_ANSWER)) {
			System.out.print(QUESTION_MESSAGE);
		
			scanner = new Scanner(System.in);
			String answer = scanner.nextLine();
			gameStatus = getGameStatus(answer);
		}
	}
	
	private GameStatus getGameStatus(String answer) {
		if (isValidAnswer(answer)) {
			List<Integer> answerNumber = getAnswerNumber(answer);
			Map<String, Integer> result = getScoreMap(answerNumber);
			
			System.out.println(result);
		}
		
		return GameStatus.WAITING_ANSWER;
	}
	
	private boolean isValidAnswer(String s) {
		if (isInteger(s) && has3Numbers(s)) {
			return true;
		}
		
		return false;
	}

	private boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	private boolean has3Numbers(String s) {
		if (s.length() == 3) {
			return true;
		}
		
		return false;
	}
	
	private List<Integer> getAnswerNumber(String s) {
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			numbers.add(Integer.parseInt(String.valueOf(s.charAt(i))));
		}
		
		return numbers;
	}
	
	private Map<String, Integer> getScoreMap(List<Integer> answerNumber) {
		Map<String, Integer> result = new HashMap<>();
		
		for(int i = 0; i < 3; i++) {
			int answer = answerNumber.get(i);
			String score = getScore(answer, i);
			result.putIfAbsent(score, 0);
			result.put(score, result.get(score) + 1);
		}
		
		return result;
	}
	
	private String getScore(int answerNumber, int index) {
		if (answerNumber == targetNumber.get(index)) {
			return "strike"; 
		}
		
		if(targetNumber.contains(answerNumber)) {
			return "ball";
		}
		
		return "";
	}

}