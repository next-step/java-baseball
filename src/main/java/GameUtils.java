import static org.apache.commons.lang3.StringUtils.isNumeric;
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

	private static String input() {
		System.out.print("숫자를 입력해주세요:");
		String input = scanner.nextLine();
		return input;
	}

	private boolean InputValidation(String input) {
		if(input.length() != 3){
			System.out.println("숫자 3개를 입력해주세요.");
			return false;
		}
		if(!isNumeric(input)){
			System.out.println("유효하지 않는 숫자입니다.");
			return false;
		}
		return  true;
	}

	public void run() {
		String input = input();
		if(!InputValidation(input)){
			return;
		}
		checkStrike(currentGame, input, 0);
		checkBall(currentGame, input, 0);
	}

	private void checkStrike(Game game, String sInput, int index) {
		if (index == 3) {
			return;
		}
		char cInput = sInput.charAt(index);
		char cAnswer = game.getAnswer().charAt(index);
		if (cInput == cAnswer) {
			game.addStrike();
		}
		checkStrike(game, sInput, index + 1);
	}

	private void checkBall(Game game, String sInput, int index) {
		if (index == 3) {
			return;
		}
		char cInput = sInput.charAt(index);
		char cTarget = game.getAnswer().charAt(index);
		if (cInput != cTarget && game.getAnswer().contains(Character.toString(cInput))) {
			game.addBall();
		}
		checkBall(game, sInput, index + 1);
	}

	public boolean isEnd() {
		return isEnd;
	}
}
