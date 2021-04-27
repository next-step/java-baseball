import java.util.Scanner;

import ui.MenuUI;

public class Main {
	public static void main(String[] args) {
		MenuUI menuUI = new MenuUI();
		Scanner scan = new Scanner(System.in);
		boolean isRunning = true;
		while (isRunning) {
			menuUI.printStartMessage();
			isRunning = menuUI.getMenuInput(scan.nextLine());
		}
	}
}
