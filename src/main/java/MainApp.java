import game.Game;
import number.RandomGenerationStrategy;
import number.UserInputGenerationStrategy;
import player.Computer;
import player.Player;
import player.User;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player computer = new Computer(RandomGenerationStrategy.getInstance());
		Player user = new User(UserInputGenerationStrategy.getInstance());
		
		Game game = new Game(computer, user);
		game.start();
	}

}
