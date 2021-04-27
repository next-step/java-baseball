package game.baseball;

import java.util.Scanner;

public class GameController {

	private Umpire umpire;
	private Pitcher pitcher;
	private Hitter hitter;

	public GameController(Umpire umpire, Pitcher pitcher, Hitter hitter) {
		this.umpire = umpire;
		this.pitcher = pitcher;
		this.hitter = hitter;
	}

	public void resetHittngNumbers() {
		hitter.resetHittingNumbers();
	}

	public void resetBaseballCounts() {
		umpire.resetBallsAndStrikes();
	}

	public void playGame() {
		while (!umpire.isOut()) {
			umpire.resetBallsAndStrikes();
			pitcher.setPitch();
			pitcher.splitPitches();
			umpire.setHitter(hitter);
			umpire.setPitcher(pitcher);
			umpire.judge();
			umpire.speakJudge();
		}
	}

	public boolean restartGame() {
		Scanner sc = new Scanner(System.in);
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int resetCommandInputNumber = sc.nextInt();
		return resetCommandInputNumber == 2;
	}
}
