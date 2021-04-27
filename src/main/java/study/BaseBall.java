package study;

import java.util.List;
import java.util.Scanner;

public class BaseBall {
	private final ScoreBoard scoreBoard = new ScoreBoard();
	private final Scanner scanner;

	private List<Integer> pitches;
	private int inningCount;

	public BaseBall(Scanner scanner) {
		this.scanner = scanner;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BaseBall baseBall = new BaseBall(sc);
		Batter batter = new Batter();

		int playState = 1;
		while (playState == 1) {
			baseBall.newGame();
			baseBall.playGame(batter);

			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			playState = sc.nextInt();
		}
	}

	private void newGame() {
		pitches = Pitcher.pitch(3);
		inningCount = 1;
	}

	private void playGame(Batter batter) {
		System.out.println("Play Ball!!!");
		Score lastScore = Score.nothing();
		while (!Score.threeStrike().equals(lastScore)) {
			try {
				lastScore = playInning(batter);
				System.out.println(lastScore);
				inningCount++;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	private Score playInning(Batter batter) {
		System.out.printf("[%d] 숫자를 입력해주세요: ", inningCount);
		List<Integer> swings = batter.swingBat(scanner.next());
		return scoreBoard.countScore(swings, pitches);
	}
}
