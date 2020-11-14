import model.Baseball;
import model.Gamer;
import util.CustomException;

public class BaseballGame {

	static Baseball baseball = new Baseball();
	static Gamer gamer = new Gamer();

	public static void main(String[] args)  {
		System.out.println(baseball.getDefaultNumbers().toString());
		gamer.playGame();
		showGameResult();
	}

	private static void showGameResult() {

	}
}
