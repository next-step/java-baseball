package baseball.referee;

import baseball.player.Player;
import baseball.report.Report;

public interface Referee {
	Report decide(Player player);

	void resetOpponent();
}
