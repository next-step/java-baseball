package roles;

import java.util.List;
import java.util.Scanner;

public class Stadium {

	private Hitter hitter = new Hitter();
	private Pitcher pitcher = new Pitcher();
	private List<Integer> GAME_NUMBERS;

	public String input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void output(String inputText) {
		System.out.println(inputText);
	}

	public void playBall() {
		output("Play Ball!!");
		GAME_NUMBERS = hitter.generateNumber();

		output("숫자를 입력해주세요 : ");
		List<Integer> pitcherNumber = pitcher.inputGameNumbers();
	}
}
