package baseballgame;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {
	private static GameStarter gameStarter = null;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		String command = "1";
		while (command.equals("1")) {
			gameStarter = new GameStarter();
			gameStarter.startGame(scanner);
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			command = scanner.nextLine();
		}
	}

}
