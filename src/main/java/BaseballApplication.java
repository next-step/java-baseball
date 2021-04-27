
import java.util.Scanner;

import core.Game;

/**
 * Description : Baseball Application main class
 *
 * Created by jychoi on 2021/04/26.
 */
public class BaseballApplication {

	public static final int INPUT_SIZE = 3;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Game game = new Game(INPUT_SIZE, sc);
		game.runGameModule();

		// 게임 종료 시
		sc.close();
	}
}

