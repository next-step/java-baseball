package com.baseball.game;

import java.util.Scanner;

public class BaseBallGame {

	private void startGame(){
		//
		boolean onGame= true;

		while(onGame){
			startInning();

			//TODO 게임 재개 여부 확인
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			Scanner scanner = new Scanner(System.in);
			String resumeText = scanner.nextLine();
			if("1".equals(resumeText)){
				onGame = true;
			} else if("2".equals(resumeText)){
				onGame = false;
			}
		}
	}

	private void startInning() {
		//TODO 3자리 숫자 생성
		String testInput = "123";// 삭제 예정

		boolean strikeout = false;
		while(!strikeout){
			// infoMessage
			System.out.print("숫자를 입력해 주세요:");

			Scanner scanner = new Scanner(System.in);
			String numbers =  scanner.nextLine();

			//TODO 입력값 유효성 검증

			//TODO strike,ball 판단

			if(testInput.equals(numbers)){
				strikeout = true;
			}
		}
	}

	public static void main(String[] args){
		//
		BaseBallGame game = new BaseBallGame();
		game.startGame();

	}
}
