package game.baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

import common.code.GameErrorCode;
import common.exception.GameException;
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
		gamePlayer.startGame();
		boolean isFinish = false;
		
		while(!isFinish) {
			int inputNumber = takeNumber("숫자를입력해주세요: ", inputScanner);
			playGame(gamePlayer, inputNumber);
			isFinish = finishGame(gamePlayer, inputScanner);
		}
	}
	
	private static int takeNumber(String message, Scanner inputScanner) {
		System.out.print(message);
		int intputNumber = 0;
		try {
			intputNumber = inputScanner.nextInt();
		}catch(InputMismatchException ime) {
			throw new GameException(GameErrorCode.INPUT_INVALID_FORMAT_ERROR
					,GameErrorCode.INPUT_INVALID_FORMAT_ERROR.getErrorMessage());
		}
		return intputNumber;
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
