package baseballgame;

import java.util.Scanner;

public class User {
	private Scanner scanner = new Scanner(System.in);

	public String setUserInputNumberArray() {
		System.out.println(PrintMessageEnum.ENTER_A_NUMBER.getMessage());
		return scanner.nextLine();
	}

}
