import com.woowa.precourse.service.BaseballGame;
import com.woowa.precourse.service.Game;

public class BaseballGameMain { 
	/* Main */
	public static void main(String[] args) {
		Game game = new BaseballGame();

		while (game.run()) {}
		game.exit();
	}
}
