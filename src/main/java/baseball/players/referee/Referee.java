package baseball.players.referee;

import baseball.players.player.Player;
import baseball.stadium.report.Report;

public interface Referee {
	Report decide(Player player);

	void resetOpponent();
}
