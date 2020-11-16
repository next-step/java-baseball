package com.taemin.baseball;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class BaseballGameManager {

	private static BaseballGameManager baseballGameManager = null;
    
	private BaseballGameManager(){}

	public static BaseballGameManager getInstance() {
		if(baseballGameManager == null) {
			baseballGameManager = new BaseballGameManager();
		}
		return baseballGameManager;
	}
	
	public void GameStart() throws Exception {
		System.out.println("BaseBall 게임 시작");
		User user = new User();
		BaseballGameRule baseballGameRule = new BaseballGameRule();
		LinkedHashSet<Integer> computerNumbers = baseballGameRule.getComputerRandomNumbers();
		boolean isWin = false;
		while(!isWin) {
			LinkedHashSet<Integer> userNumbers = user.getUserNumbers();
			isWin = baseballGameRule.isWin(computerNumbers, userNumbers);
		}
		isGameRestart(); 
	}
	
	private void isGameRestart() throws Exception {
		System.out.print("게임을 새로 시작하려면 1, 종료하실려면 2를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		int gameRestartInput = scanner.nextInt();
		if(gameRestartInput == 1) {
			GameStart(); return;
		}
		if(gameRestartInput == 2) { 
			GameExit(); return;
		}
		isGameRestart();
	}
	
	private void GameExit() {
		System.out.println("BaseBall 게임 종료");
		System.exit(0);
	}

}
