package NumberBaseballGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NumberBaseballGame {

	private Integer[] answer;

	public NumberBaseballGame() {
		answer = new Integer[3];
	}

	public void setAnswer() {
		Integer[] numArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<Integer> numList = new ArrayList<Integer>(Arrays.asList(numArray));
		int randomIndex = 0;

		for (int i = 0; i < answer.length; i++) {
			randomIndex = (int)(Math.random() * (numList.size()));
			answer[i] = numList.get(randomIndex);
			numList.remove(randomIndex);
		}
	}

	public String writeInputDate() {

		String inputData = "";
		Scanner scanner = new Scanner(System.in);

		System.out.print("숫자를 입력해주세요 : ");

		inputData = scanner.next();

		scanner.close();

		return inputData;
	}

	public static void main(String[] args) {

		//while (true) {
		String inputData = "";

		NumberBaseballGame game = new NumberBaseballGame();

		game.setAnswer();

		inputData = game.writeInputDate();

		// checkInputData();

		// nextProcess();
		//}
	}
}
