package ui;

import java.util.Scanner;

public class ScannerInputManager implements InputManager {
	
	private static final Scanner SCANNER = new Scanner(System.in);
	
	@Override
	public int nextInt() {
		return SCANNER.nextInt();
	}

}
