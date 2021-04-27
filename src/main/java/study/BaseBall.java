package study;

import java.util.List;
import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) {
		ScoreBoard scoreBoard = new ScoreBoard();
		Pitcher pitcher = new Pitcher();
		Batter batter = new Batter();

		Scanner sc = new Scanner(System.in);

		int playState = 1;
		while (playState == 1) {
			List<Integer> pitches = pitcher.pitch(3);
			Score score = Score.nothing();
			int count = 1;

			System.out.println("Play Ball!!!");

			while (!Score.threeStrike().equals(score)) {
				try {
					System.out.printf("[%d] 숫자를 입력해주세요: ", count);
					List<Integer> swings = batter.swingBat(sc.next());
					score = scoreBoard.countScore(swings, pitches);
					System.out.println(score);
					count++;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			playState = sc.nextInt();
		}
	}
}
