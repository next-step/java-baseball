package game.baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

import common.code.GameErrorCode;
import common.exception.GameException;
import common.models.ThreeNumbers;


/**
 * @brief
 * Game application
 * @details user가 사용할 Game application입니다.
 * @author SUNJU
 * @since 2021. 4. 26.
 * @version 1.0
 * @see
 * <pre>
 *     since          author              description
 *  ===========    =============    ===========================
 *  2021. 4. 27.     SUNJU         최초 생성
 * </pre>

 */
public class GameApp {
	
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
	
	/**
	 * @brief 메시지 출력 및 사용자 값 입력
	 * @param message 출력 할 메시지
	 * @param inputScanner
	 * @return
	 */
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
	
	/**
	 * @brief 게임 플레이
	 * @param gamePlayer
	 * @param inputNumber attackNumber
	 */
	private static void playGame(GamePlayer gamePlayer, int inputNumber) {
		String resultMessage = gamePlayer.playGame(new ThreeNumbers(inputNumber));
		
		System.out.println(resultMessage);
	}
	
	/**
	 * @brief 게임 종료 여부 확인
	 * @param gamePlayer
	 * @param inputScanner
	 * @return
	 */
	static private boolean finishGame(GamePlayer gamePlayer, Scanner inputScanner) {
		if (!gamePlayer.isFinish()) {
			return false;
		}
		
		int inputNumber = takeNumber("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", inputScanner);
		boolean isContinue = isContinueGame(inputNumber);
		
		if (!isContinue) {
			return true;
		}
		
		// reset game, when finish play
		gamePlayer.startGame();
				
		return false;
	}
	
	/**
	 * @brief 게임을 계속 진행 할 지 여부 판단
	 * @param inputNumber 사용자 입력 값
	 * @return
	 */
	private static boolean isContinueGame(int inputNumber) {
		if (inputNumber != 1 && inputNumber != 2) {
			throw new GameException(GameErrorCode.NUMBER_RANGE_ERROR
					,GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		}
		
		if (inputNumber == 1) {
			return true;
		}
		
		return false;
	}
	
}
