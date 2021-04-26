package ui;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerInputManager implements InputManager {

	private final OutputManager outputManager = PrintOutputManager.getInstance();
	
	private static InputManager inputManager = new ScannerInputManager();
	
	private ScannerInputManager() {
	}

	public static InputManager getInstance() {
		return inputManager;
	}

	private static final Scanner SCANNER = new Scanner(System.in);

	@Override
	public int nextInt() {
		int result = 0;
		
		try {
			result = SCANNER.nextInt();
		} catch (InputMismatchException e) {
			askReinput();
			return nextInt();
		} catch (NoSuchElementException | IllegalStateException e) {
			askReinput();
			return nextInt();
		}
		
		return result;
	}
	
	private void askReinput() {
		outputManager.print("재입력 : ");
		SCANNER.nextLine();
	}

}
