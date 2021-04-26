import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answer {
	private List<Integer> answer;

	public List<Integer> generateRandomNumber() {
		Set<Integer> generatedNumbersInSet = new HashSet<Integer>();

		while (generatedNumbersInSet.size() != 3) {
			int randomNumber = (int)((Math.random() * 9) + 1);
			generatedNumbersInSet.add(randomNumber);
		}
		List<Integer> generatedNumbersInList = new ArrayList<>(generatedNumbersInSet);
		return generatedNumbersInList;
	}

	public List<Integer> getAnswer() {
		return this.answer;
	}

	public void setAnswer(List<Integer> generatedAnswer) {
		this.answer = generatedAnswer;
	}
}
