package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

	private Scanner sc = new Scanner(System.in);
	private List<Integer> swingNumbers;

	public List<Integer> swingNumber() {
		swingNumbers = new ArrayList<>();

		System.out.print("숫자를 입력해 주세요: ");
		int inputNum = sc.nextInt();

		swingNumbers.add(inputNum / 100);
		inputNum = inputNum % 100;

		swingNumbers.add(inputNum / 10);
		inputNum = inputNum % 10;

		swingNumbers.add(inputNum);

		return swingNumbers;
	}
}
