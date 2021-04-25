import java.util.LinkedHashSet;
import java.util.concurrent.ThreadLocalRandom;

public class BaseballProblemGenerator {

	private final int problemSize = 3;
	private final int min = 1;
	private final int max = 9;

	private LinkedHashSet<Integer> problems;

	public BaseballProblemGenerator() {
		// 메모리를 문제 개수에 맞게 초기화 한다.
		this.problems = new LinkedHashSet<>(problemSize);
	}

	public LinkedHashSet<Integer> generate() {
		this.createRandomNumbers();
		return this.problems;
	}

	public void resetProblem() {
		this.problems.clear();
		this.createRandomNumbers();
	}

	private void createRandomNumbers() {
		int num;

		while (!this.isCreatedAllNumbers()) {
			num = ThreadLocalRandom.current().nextInt(min, max + 1);
			this.problems.add(num);
		}
	}

	private boolean isCreatedAllNumbers() {
		if (this.problems.size() == problemSize) {
			return true;
		}
		return false;
	}
}
