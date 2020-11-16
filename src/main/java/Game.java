
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
	private static String QUESTION_MESSAGE = "숫자를 입력해주세요 : ";
	private static String COMPLETE_ANSWER = NUMBER_LENGTH + ScoreType.STRIKE.getDescription();
	private static String COMPLETE_MESSAGE = NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
	
	private Scanner scanner;

	private GameStatus gameStatus = GameStatus.IN_PROGRESS;

	private List<Integer> targetNumber;
	
	public void playRound() {
		System.out.println(START_MESSAGE);

		generateTargetNumber();
		
		inputAnswer();
		
		System.out.println(COMPLETE_MESSAGE);
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
		
		while (numbers.size() < NUMBER_LENGTH) {
			numbers.add((int)(Math.random() * 9) + 1);
		}
		
		return numbers;	
	}
	
	private void inputAnswer() {
		while (gameStatus.equals(GameStatus.IN_PROGRESS)) {
			System.out.print(QUESTION_MESSAGE);
		
			scanner = new Scanner(System.in);
			String answer = scanner.nextLine();
			gameStatus = getGameStatus(answer);
		}
	}
	
	private GameStatus getGameStatus(String answer) {
		String printMessage = "";
		
		if (isValidAnswer(answer)) {
			List<Integer> answerNumber = getAnswerNumber(answer);
			Map<ScoreType, Integer> result = getScoreMap(answerNumber);
			
			printMessage = getScorePrintMessage(result);
			System.out.println(printMessage);
		}
		
		if (printMessage.equals(COMPLETE_ANSWER)) {
			return GameStatus.COMPLETED;
		}
		
		return GameStatus.IN_PROGRESS;
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
	
	private List<Integer> getAnswerNumber(String s) {
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 0; i < NUMBER_LENGTH; i++) {
			numbers.add(Integer.parseInt(String.valueOf(s.charAt(i))));
		}
		
		return numbers;
	}
	
	private Map<ScoreType, Integer> getScoreMap(List<Integer> answerNumber) {
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
	
	private String getScorePrintMessage(Map<ScoreType, Integer> result) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (ScoreType scoreType : ScoreType.values()) {
			stringBuilder.append(getScorePrintString(scoreType, result));
		}
		
		if (stringBuilder.toString().isEmpty()) {
			return "낫싱";
		}
		
		return stringBuilder.toString();
	}
	
	private String getScorePrintString(ScoreType scoreType, Map<ScoreType, Integer> result) {
		if (result.containsKey(scoreType)) {
			int count = result.get(scoreType);
			return scoreType.print(count);
		}
		
		return "";
	}

}