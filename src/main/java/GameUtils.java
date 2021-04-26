import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class GameUtils {
	private Game currentGame;
	private boolean isEnd;
	private boolean isRestart;
	private static Scanner scanner;

	private static int RANDOM_MAX = 9;
	
	GameUtils(Game game) {
		this.currentGame = game;
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
		for(Integer integer : set){
			stringBuilder.append(integer);
		}
		return stringBuilder.toString();
	}

	public boolean isEnd() {
		return isEnd;
	}
}
