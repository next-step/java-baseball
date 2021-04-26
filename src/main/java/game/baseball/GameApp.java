package game.baseball;

import java.util.Scanner;

import common.models.PlayResultModel;
import common.models.ThreeNumbers;

/**
 * @author SUNJU
 *
 */
public class GameApp {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		GamePlayer gamePlayer = new GamePlayer();
		boolean isFinish = false;
		
		while(!isFinish) {
			int inputNumber = takeNumber("숫자를입력해주세요: ", inputScanner);
			playGame(gamePlayer, inputNumber);
			isFinish = finishGame(gamePlayer, inputScanner);
		}
	}
	
	private static int takeNumber(String message, Scanner inputScanner) {
		System.out.println(message);
		
		return inputScanner.nextInt();
	}
	
	private static void playGame(GamePlayer gamePlayer, int inputNumber) {
		String resultMessage = gamePlayer.playGame(new ThreeNumbers(inputNumber));
		
		System.out.println(resultMessage);
	}
	
	static private boolean finishGame(GamePlayer gamePlayer, Scanner inputScanner) {
		if (!gamePlayer.isFinish()) {
			return false;
		}
		
		int inputNumber = takeNumber("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", inputScanner);
		if (inputNumber == 2) {
			return true;
		}
		
		// reset game, when finish play
		gamePlayer.startGame();
				
		return false;
	}
}
