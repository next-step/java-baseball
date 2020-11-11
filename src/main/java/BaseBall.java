import java.util.HashSet;
import java.util.Random;

public class BaseBall {

	Random randomGenerator = new Random();

	public boolean play() {
		HashSet<Integer> answerSet = selectNonoverlapThreeNumber();
//		System.out.println(answerSet);
		return true;
	}

	private HashSet<Integer> selectNonoverlapThreeNumber() {
		HashSet<Integer> answerSet = new HashSet<>();
		do {
			int randomNum = randomGenerator.nextInt(9) + 1;
			answerSet.add(randomNum);
		} while (answerSet.size() < 3);

		return answerSet;
	}
}
