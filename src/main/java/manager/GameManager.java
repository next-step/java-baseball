package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import generator.RandomNumberGenerator;
import umpire.Umpire;

public class GameManager {

	private List<Integer> targetNumber;
	private RandomNumberGenerator generator;
	private Umpire umpire;

	public GameManager() {
		generator = new RandomNumberGenerator();
		this.targetNumber = generator.getTargetNumber();
		umpire = new Umpire(targetNumber);
	}

	public void play() {
		boolean isCorrectAnswer;
		do {
			System.out.print("숫자를 입력해주세요 : ");
			Scanner scanner = new Scanner(System.in);
			isCorrectAnswer = umpire.check(convertInputType(scanner.next()));
		} while (!isCorrectAnswer);

	}

	protected List<Integer> convertInputType(String input) {
		List<Integer> numberList = new ArrayList<>();
		String[] inputArr = input.split("");
		for (int i = 0; i < input.length(); i++) {
			numberList.add(Integer.parseInt(inputArr[i]));
		}
		return numberList;
	}

	//TODO 입력값유효성체크 추가
	protected boolean validateInput(String input) {
		boolean isValid = (input.length() == 3 && input.matches("^[0-9]+$"));
		if (!isValid) {
			System.out.println(input + " 유효하지 않은 입력입니다.");
		}
		return isValid;
	}
}
