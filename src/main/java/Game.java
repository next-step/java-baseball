
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import type.GameStatus;
import type.ScoreType;

public class Game {
	private static int NUMBER_LENGTH = 3;
	private static String START_MESSAGE = "게임을 시작합니다.";
	private static String END_MESSAGE = NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
	
	private static String ANSWER_CLEAR = NUMBER_LENGTH + ScoreType.STRIKE.getDescription();
	private static String QUESTION = "숫자를 입력해주세요 : ";
	private static String RESULT_NOTHING = "낫싱";
	
	private Scanner scanner;

	private GameStatus gameStatus = GameStatus.RUNNING;

	private List<Integer> targetNumber;
	
	public void play() {
		System.out.println(START_MESSAGE);

		init();
		
		run();
		
		System.out.println(END_MESSAGE);
	}
	
	private void init() {
		setTargetNumber();
	}
	
	private void setTargetNumber() {
		Set<Integer> numbers = new LinkedHashSet<>();
		
		while (numbers.size() < NUMBER_LENGTH) {
			numbers.add((int)(Math.random() * 9) + 1);
		}
		
		targetNumber = new ArrayList<Integer>();
		for (int number : numbers) {
			targetNumber.add(number);
		}
	}
	
	private void run() {
		while (gameStatus.equals(GameStatus.RUNNING)) {
			setQuestion();
		
			String answer = getAnswer();
			
			setGameStatus(answer);
		}
	}
	
	private void setQuestion() {
		System.out.print(QUESTION);
	}
	
	private String getAnswer() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	private void setGameStatus(String answer) {
		String result = "";
		
		if (isValidAnswer(answer)) {
			printResult(answer);
		}
		
		if (result.equals(ANSWER_CLEAR)) {
			gameStatus = GameStatus.CLEAR;
		}
		
		gameStatus = GameStatus.RUNNING;
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
		if (s.length() == NUMBER_LENGTH) {
			return true;
		}
		
		return false;
	}
	
	private void printResult(String answer) {
		List<Integer> answerNumber = convert(answer);
		Map<ScoreType, Integer> result = getResultMap(answerNumber);
		String printMessage = getPrintMessage(result);
		System.out.println(printMessage);
	}
	
	private List<Integer> convert(String s) {
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 0; i < NUMBER_LENGTH; i++) {
			numbers.add(Integer.parseInt(String.valueOf(s.charAt(i))));
		}
		
		return numbers;
	}
	
	private Map<ScoreType, Integer> getResultMap(List<Integer> answerNumber) {
		Map<ScoreType, Integer> result = new HashMap<>();
		
		for(int i = 0; i < NUMBER_LENGTH; i++) {
			int answer = answerNumber.get(i);
			ScoreType score = getScoreType(answer, i);
			result.putIfAbsent(score, 0);
			result.put(score, result.get(score) + 1);
		}
		
		return result;
	}
	
	private ScoreType getScoreType(int answerNumber, int index) {
		if (answerNumber == targetNumber.get(index)) {
			return ScoreType.STRIKE; 
		}
		
		if (targetNumber.contains(answerNumber)) {
			return ScoreType.BALL;
		}
		
		return ScoreType.NONE;
	}
	
	private String getPrintMessage(Map<ScoreType, Integer> result) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (ScoreType scoreType : ScoreType.values()) {
			stringBuilder.append(getPrintMessage(scoreType, result));
		}
		
		if (stringBuilder.toString().isEmpty()) {
			return RESULT_NOTHING;
		}
		
		return stringBuilder.toString();
	}
	
	private String getPrintMessage(ScoreType scoreType, Map<ScoreType, Integer> result) {
		if (result.containsKey(scoreType)) {
			int count = result.get(scoreType);
			return scoreType.printWithScore(count);
		}
		
		return "";
	}

}