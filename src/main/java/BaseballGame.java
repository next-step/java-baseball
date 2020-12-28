package main.java;

import java.util.Scanner;

public class BaseballGame {
	
	private static final int LEN = 3;
	private static final char CONTINUE = '1';
	private static final char EXIT = '2';
	
	public void run() {
		BaseballGame baseballGame = new BaseballGame();
		do {
			baseballGame.playBaseBallGame();
		}while(baseballGame.isNewGame());	
	}
	
	public boolean isNewGame() {
		System.out.println("3개를 모두 맞히셨습니다! 게임종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return checkInput(input);
	}


	public boolean checkInput(String input) {
		if(isInvalidLen(input) || isInvalidVal(input)) 
			throw new IllegalArgumentException("ERROR: 입력 값이 잘못 되었습니다.");
		if(input.equals("1"))
			return true;
		return false;
	}
	
	private boolean isInvalidVal(String input) {
		if(input.charAt(0) == CONTINUE || input.charAt(0) == EXIT) return false;
		return true;
	}

	private boolean isInvalidLen(String input) {
		if(input.length() != 1) return true;
		return false;
	}

	private void playBaseBallGame() {
		//난수 생성
		Computer computer = new Computer();
		User user = new User();
		
		do {
			user.setNumbers();
		}while(match(computer.getNumbers(), user.getNumbers()));
	}

	//조건 구현
	public boolean match(String computerNumbers, String userNumbers) {
		int[] count = new int[2];
		for(int i=0;i<LEN;i++) {
			checkNumber(computerNumbers, userNumbers, i , count);
		}
		return matchResult(count);
	}

	private void checkNumber(String computerNumbers, String userNumbers, int idx, int[] count) {
		if(computerNumbers.charAt(idx) == userNumbers.charAt(idx)) {
			count[0]++;
			return;
		}
		Character c = userNumbers.charAt(idx);
		if(computerNumbers.contains(c.toString())) {
			count[1]++;
		}
		return;
	}
	
	private boolean matchResult(int[] count) {
		printResult(count);
		if(count[0] == LEN) {
			return false;
		}
		return true;
	}
	
	private void printResult(int[] count) {
		if(count[0] == LEN) {
			System.out.println(count[0] + " 스트라이크");
			return;
		}	
		if(count[0] > 0)
			System.out.print(count[0] + " 스트라이크 ");
		if(count[1] > 0)
			System.out.print(count[1]+"볼");
		if(count[0] == 0 && count[1] == 0) 
			System.out.print("낫싱");
		System.out.println();
		return;
	}

}
