import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GameUtils {
	private boolean isEnd;
	private static Scanner scanner;

	private static int RANDOM_MAX = 9;
	
	GameUtils() {
		setupGame();
	}

	void setupGame() {
		scanner = new Scanner(System.in);
		this.isEnd = false;
	}

	public static String answerGenerator() {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		Set<Integer> set = new LinkedHashSet<>();
		while (set.size() < 3) {
			set.add(random.nextInt(RANDOM_MAX) + 1);
		}
		while(set.iterator().hasNext()){
			stringBuilder.append(set.iterator().next());
		}
		return stringBuilder.toString();
	}

	public boolean isEnd() {
		return isEnd;
	}
}
