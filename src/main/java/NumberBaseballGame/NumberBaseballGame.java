package NumberBaseballGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

}
