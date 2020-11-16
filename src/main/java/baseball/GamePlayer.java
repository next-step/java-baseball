package baseball;

import java.util.Scanner;

public class GamePlayer {


	BaseballScore baseballScore;
	private final Scanner sc = new Scanner(System.in);
	public void playGame(){
		boolean isEndGame = false;
		BaseballGame baseballGame = new BaseballGame();
		while (!isEndGame){
			System.out.print("숫자를 입력해주세요 :");
			String input = sc.nextLine();
			baseballScore = baseballGame.checkResult(input);
			printResultMessage(baseballScore);
			isEndGame = baseballScore.isEndGame();
		}

	}

	private void printResultMessage(BaseballScore baseballScore){
		System.out.println(baseballScore.getMessage());
	}
}
