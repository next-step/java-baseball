import java.util.Scanner;

import ui.MenuUI;

public class Main {
	public static void main(String[] args) {
		MenuUI menu = new MenuUI();
		Scanner scan = new Scanner(System.in);
		boolean isRunning = true;
		while (isRunning) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			isRunning = menu.getMenuInput(scan.nextLine());
		}
	}

}


