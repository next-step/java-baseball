import machine.Machine;
import player.Player;

public class NumberBaseballApplication {
	public static void main(String[] args) {
		Machine machine = new Machine();
		machine.addPlayer(new Player());
		machine.run();
	}
}
