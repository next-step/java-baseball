package study;

import java.util.List;
import java.util.Scanner;

public class BaseBall {
	private static final Scanner SCANNER = new Scanner(System.in);
	private final ScoreBoard scoreBoard = new ScoreBoard();
	private final Batter batter = new Batter();

	private List<Integer> pitches;
	private int inningCount;
	private Score lastScore;

	void newGame() {
		this.pitches = Pitcher.pitch(3);
		this.lastScore = Score.nothing();
		this.inningCount = 1;
	}

	void playGame() {
		while (isGameEnd()) {
			playInning();
		}
	}

	private void playInning() {
		try {
			System.out.printf("[%d] 숫자를 입력해주세요: ", this.inningCount);

			List<Integer> swings = batter.swingBat(SCANNER.next());
			this.lastScore = this.scoreBoard.countScore(swings, this.pitches);

			System.out.println(this.lastScore);
			inningCount++;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private boolean isGameEnd() {
		return !Score.threeStrike().equals(this.lastScore);
	}
}
