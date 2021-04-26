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
	
}
