package study;

import java.util.Scanner;

public class BaseBallApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BaseBall baseBall = new BaseBall();

		int playState = 1;
		while (playState == 1) {
			baseBall.newGame();
			System.out.println("Play Ball!!!");
			baseBall.playGame();
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			playState = sc.nextInt();
		}
	}
}
