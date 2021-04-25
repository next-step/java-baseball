import game.Game;
import player.Player;
import player.PlayerFactory;

public class MainApp {

	public static void main(String[] args) {
		Player user = new PlayerFactory().user();
		
		Game game = new Game(user);
		game.start();
	}

}
