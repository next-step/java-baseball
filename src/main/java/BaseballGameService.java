import java.util.Random;

public class BaseballGameService {

	public int[] peek3RandomDistinctNumbers() {
		int[] peek = new int[3];
		boolean[] seen = new boolean[10];
		int pointer = 0;
		Random random = new Random();
		while (pointer < peek.length) {
			peek[pointer++] = peekDistinct(random, seen);
		}
		return peek;
	}

	private int peekDistinct(Random random, boolean[] seen) {
		int randomInt = random.nextInt(9) + 1;
		if (seen[randomInt]) {
			return peekDistinct(random, seen);
		}
		seen[randomInt] = true;
		return randomInt;
	}

}
