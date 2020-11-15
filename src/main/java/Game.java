
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
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
			
			validateAnswer(answer);
		}
	}
	
	private void validateAnswer(String s) {
		if (isInteger(s) && has3Numbers(s)) {
			System.out.println("유효한 대답입니다. 조건 검사 진행 예정입니다");
		}
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

}