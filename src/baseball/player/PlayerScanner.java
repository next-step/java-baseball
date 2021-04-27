package baseball.player;

import java.util.Scanner;

import baseball.Baseball;
import baseball.util.GameStatus;
import baseball.util.TypeConverter;

public class PlayerScanner {
	
	static Scanner scanner = new Scanner(System.in);

	public static Baseball makeBall() {
		String input = scanner.nextLine();
		InputValidate.validationChecker(input);		
		return new Baseball(input);		
	}
	
	public static boolean checkRestart() {
		String input = scanner.nextLine();
		return (TypeConverter.StringToInt(input) == GameStatus.RESTART_CODE); 
	}

}
