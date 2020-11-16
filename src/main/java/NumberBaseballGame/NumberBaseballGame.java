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

	public int[] writeInputDate() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("숫자를 입력하세요 : ");
		String scData = scanner.next();

		String[] scDataToken = scData.split("(?!^)");
		int[] inputData = new int[3];

		for (int i = 0; i < 3; i++) {
			inputData[i] = Integer.parseInt(scDataToken[i]);
		}

		return inputData;
	}

	public static void main(String[] args) {

		int[] inputData = new int[3];
		NumberBaseballGame game = new NumberBaseballGame();

		game.setAnswer();
		inputData = game.writeInputDate();

	}

}
