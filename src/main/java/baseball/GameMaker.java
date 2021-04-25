package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GameMaker {
	public Set<Integer> generateRandomNumber() {
		Random random = new Random();
		Set<Integer> numberSet = new HashSet<>();
		do {
			numberSet.add(random.nextInt(9) + 1);
		} while (numberSet.size() < 3);
		return numberSet;
	}

	public Set<Integer> inputNumberUntilSuccess() {
		try {
			Set<Integer> inputNumberSet = inputNumber();
			return inputNumberSet;
		} catch (RuntimeException e) {
			System.out.println("중복되지않은 3자리 정수만 허용됩니다.");
			return inputNumberUntilSuccess();
		}
	}

	public Set<Integer> inputNumber(){
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요 :");
		int inputNumber = sc.nextInt();

		validateInputNumber(inputNumber);
		Set<Integer> numberSet = toSetNumber(inputNumber);
		validateInputSetNumber(numberSet);

		return numberSet;
	}

	public Set<Integer> toSetNumber(int number) {
		Set<Integer> numberSet = new HashSet<>();
		while (number > 0) {
			numberSet.add(number % 10);
			number = number / 10;
		}
		return numberSet;
	}

	public boolean validateInputNumber(int number) {
		int pos = (int)(Math.log10(number)+1);
		if(pos != 3){
			throw new RuntimeException();
		}
		return true;
	}

	public boolean validateInputSetNumber(Set numberSet) {
		if(numberSet.size() != 3){
			throw new RuntimeException();
		}
		return true;
	}
}
