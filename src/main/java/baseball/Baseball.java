package baseball;

import baseball.players.opponent.Computer;
import baseball.players.player.Player;
import baseball.players.player.ScannerPlayer;
import baseball.players.referee.DefaultReferee;
import baseball.players.referee.Referee;
import baseball.stadium.Stadium;
import baseball.stadium.display.DefaultDisplay;
import baseball.stadium.display.Display;

public class Baseball {
	public static void main(String[] args) {
		Referee referee = new DefaultReferee(new Computer());
		Display display = new DefaultDisplay();
		Player player = new ScannerPlayer();

		Stadium stadium = new Stadium(referee, display);
		stadium.start(player);
	}
}
