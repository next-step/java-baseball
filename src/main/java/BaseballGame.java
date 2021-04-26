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
		
}
