package baseball;

import java.util.Scanner;

public class BaseballPlay extends Baseball {

	public String USER_NUMBER = "";
	public boolean gameExit = false;
	
	public boolean numberCheck = false;
	
	@Override
	public void start() {
		
	}

	@Override
	public void play() {
		Scanner sc = new Scanner(System.in);
		
	}

	@Override
	public boolean end() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int statue = sc.nextInt();
		
		if(statue == 1) {
			gameExit = true;
		}

		return gameExit;
	}

}
