package baseball;

import java.util.HashSet;
import java.util.InputMismatchException;
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

	public int scanNumber(){
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요 :");
		try {//try-catch문 안의 if문도 depth가 추가되는건가?
			int inputNumber = sc.nextInt();
			return inputNumber;
		} catch (InputMismatchException e){
			System.out.println("3자리 정수만 허용됩니다.");
			return scanNumber();
		}
	}
}
