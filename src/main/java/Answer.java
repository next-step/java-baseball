import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answer {
	private List<Integer> answer;

	public List<Integer> generateRandomNumber() {
		Set<Integer> generatedNumbersInSet = new HashSet<Integer>();

		while (generatedNumbersInSet.size() != 3) {
			generatedNumbersInSet.add((int)(Math.random() * 10));
		}
		List<Integer> generatedNumbersInList = new ArrayList<>(generatedNumbersInSet);
		return generatedNumbersInList;
	}
}
