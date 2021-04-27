import process.GameManager;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		GameManager gameManager = new GameManager(new Scanner(System.in));
		gameManager.startGame();
	}
}
