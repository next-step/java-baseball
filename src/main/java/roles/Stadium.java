package roles;

import java.util.List;
import java.util.Scanner;

public class Stadium {

	private Hitter hitter = new Hitter();
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
	}
}
