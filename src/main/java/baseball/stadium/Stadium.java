package baseball.stadium;

import baseball.stadium.display.Display;
import baseball.players.player.Player;
import baseball.players.referee.Referee;
import baseball.stadium.report.Report;

public class Stadium {
	private Referee referee;
	private Display display;

	public Stadium(Referee referee, Display display) {
		this.referee = referee;
		this.display = display;
	}

	public void start(Player player) {
		do {
			inning(player);
		} while (restart(player));
	}

	public boolean restart(Player player) {
		display.restartMessage();
		if (!player.isContinue())
			return false;

		this.referee.resetOpponent();
		return true;
	}

	public Report inning(Player player) {
		Report report = Report.EMPTY;
		while (report.isContinues()) {
			try {
				report = pitching(player);
			} catch (Exception e) {
				display.errorMessage(e.getMessage());
			}
		}
		return report;
	}

	private Report pitching(Player player) {
		display.askMessage();
		Report report = referee.decide(player);
		display.resultMessage(report);
		return report;
	}
}
