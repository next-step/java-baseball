import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
	
	public BaseballGame() {}
	
	/**
	* 야구게임을 실행합니다.
	*/
	public void playBall() {
		Scanner scanner = startUI();
		
		endUI(scanner);
	}
	
	/**
	* UI 관련된 기능을 실행합니다.
	*
	* @return Scanner
	*/
	private Scanner startUI() {
		return new Scanner(System.in);
	}
	
	/**
	 * UI와 관련된 기능을 종료합니다.
	 *
	 * @param scanner
	 */
	private void endUI(Scanner scanner) {
		scanner.close();
	}
	
	/**
	 * 3자리의 난수를 생성합니다.
	 *
	 * @return String
	 */
	private String createRandomNumber() {
		double randomNumber = Math.random() * 1000;
		return String.format("%.0f", randomNumber);
	}
	
	/**
	 * 숫자를 입력합니다.
	 *
	 * @param scanner
	 * @return String
	 */
	private String insertNumber(Scanner scanner) {
		String insertText = scanner.nextLine();
		
		while (!validateInsertText(insertText)) {
			System.out.println(BaseballGameConstant.ENTER_CORRECT_NUMBER);
			System.out.print(BaseballGameConstant.REQ_ENTER_NUMBER);
			
			insertText = scanner.nextLine();
		}
		return insertText;
	}
	
	/**
	 * 입력한 문자열이 유효한 문자열인지 체크합니다.
	 *
	 * @param insertText
	 * @return boolean
	 * @author 최원준
	 */
	private boolean validateInsertText(String insertText) {
		String regExp = "^[0-9]{3}$";
		return insertText.matches(regExp);
	}
	
	/**
	 * 스트라이크를 체크합니다.
	 *
	 * @param randomNumberArr
	 * @param insertNumberArr
	 * @return int
	 */
	private int checkStrike(int index, String[] randomNumberArr, String[] insertNumberArr) {
		if (randomNumberArr[index].equals(insertNumberArr[index])) {
			return 1;
		}
		
		return 0;
	}
	
	/**
	 * 볼을 체크합니다.
	 *
	 * @param strikeScore
	 * @param randomNumberArr
	 * @param insertNumber
	 * @return int
	 */
	private int checkBall(int strikeScore, String[] randomNumberArr, String insertNumber ) {
		if (strikeScore > 0) {
			return 0;
		}
		
		if (Arrays.asList(randomNumberArr).contains(insertNumber)) {
			return 1;
		}
		
		return 0;
	}
	
	/**
	 * 낫싱을 체크합니다.
	 *
	 * @param totalStrikeScore
	 * @param totalBallScore
	 * @return boolean
	 */
	private boolean checkNothing(int totalStrikeScore, int totalBallScore ) {
		if (totalStrikeScore == 0 && totalBallScore == 0) {
			System.out.println(BaseballGameConstant.NOTHING);
			return true;
		}
		return false;
	}
	
	/**
	 * 3 Strike를 체크합니다.
	 *
	 * @param totalStrikeScore
	 * @return boolean
	 */
	private boolean checkThreeStrike(int totalStrikeScore) {
		if (totalStrikeScore == 3) {
			System.out.println(totalStrikeScore + BaseballGameConstant.STRIKE);
			System.out.println(BaseballGameConstant.CORRECT_ANSWER);
			return true;
		}
		
		return false;
	}
}
