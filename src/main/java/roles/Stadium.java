package roles;

import java.util.Scanner;

public class Stadium {
	public String input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void output(String inputText) {
		System.out.println(inputText);
	}

	public void playBall() {
		output("Play Ball!!");
	}
}
