package baseball;

import java.util.Scanner;

public class GamePlayer {


	BaseballScore baseballScore;
	private final Scanner sc = new Scanner(System.in);
	BaseballGame baseballGame;
	boolean isEndGame = false;
	public void playGame(){
		baseballGame = new BaseballGame();
		while (!isEndGame){
			System.out.print("숫자를 입력해주세요 :");
			String input = sc.nextLine();
			baseballScore = baseballGame.checkResult(input);
			printResultMessage(baseballScore);
			isEndGame = baseballScore.isEndGame();
			retry(isEndGame);
		}

	}

	private void retry(boolean isEndGame) {
		if (!isEndGame){
			return;
		}
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int input = sc.nextInt();
		System.out.println(input);
		if (input == 1){
			this.isEndGame = false;
			baseballGame = new BaseballGame();
		}

	}

	private void printResultMessage(BaseballScore baseballScore){
		System.out.println(baseballScore.getMessage());
	}
}
