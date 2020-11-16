import model.Baseball;
import model.Gamer;

public class BaseballGame {

	private static Baseball baseball = new Baseball();
	private static Gamer gamer = new Gamer(baseball);

	public static void main(String[] args) {
		gamer.playGame();
	}
}
