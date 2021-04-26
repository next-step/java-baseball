package game.baseball;

import java.util.Scanner;

import common.models.PlayResultModel;
import common.models.ThreeNumbers;

/**
 * @author SUNJU
 *
 */
public class GameApp {
	static final GamePlayer gamePlayer = new GamePlayer();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		boolean isFinish = false;
		
		while(!isFinish) {
			System.out.print("숫자를입력해주세요: ");
			
			int inputNumber = inputScanner.nextInt();
			
			PlayResultModel playResultModel = gamePlayer.playGame(new ThreeNumbers(inputNumber));
			
			System.out.println(playResultModel.getResultMessage());
			
			isFinish = finishGame(playResultModel.isFinish(), inputScanner);
		}
	}
	
	static private boolean finishGame(boolean isFinishPlay, Scanner inputScanner) {
		if (!isFinishPlay) {
			return false;
		}
		
		// reset game, when finish play
		gamePlayer.startGame();
		
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		
		int inputNumber = inputScanner.nextInt();
		
		if (inputNumber == 2) {
			return true;
		}
		
		return false;
	}
}
