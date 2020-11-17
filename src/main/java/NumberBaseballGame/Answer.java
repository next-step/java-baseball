package NumberBaseballGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {

	private int[] answer;

	public Answer() {
		answer = new int[3];

		Integer[] numArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<Integer> numList = new ArrayList<Integer>(Arrays.asList(numArray));
		int randomIndex = 0;

		for (int i = 0; i < 3; i++) {
			randomIndex = (int)(Math.random() * (numList.size()));
			answer[i] = numList.get(randomIndex);
			numList.remove(randomIndex);
		}
	}

	public Answer(int firstValue, int secondValue, int thirdValue) {
		answer = new int[3];

		answer[0] = firstValue;
		answer[1] = secondValue;
		answer[2] = thirdValue;
	}

	public int[] getAnswer() {
		return answer;
	}

}
