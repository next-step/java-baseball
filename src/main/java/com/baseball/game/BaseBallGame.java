package com.baseball.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.baseball.message.UIMessage;
import com.baseball.rule.BallPlayer;
import com.baseball.rule.BallGenerator;

public class BaseBallGame {

	private void startGame() {
		//
		boolean onGame = true;

		while (onGame) {
			BaseBallInning baseBallInning = new BaseBallInning();
			baseBallInning.startInning();

			//게임 재개 여부 확인
			System.out.println(UIMessage.RESUME_INFO);

			Scanner scanner = new Scanner(System.in);
			String resumeText = scanner.nextLine();

			if ("1".equals(resumeText)) {
				onGame = true;
			} else if ("2".equals(resumeText)) {
				onGame = false;
			}
		}
	}

	public static void main(String[] args) {
		//
		BaseBallGame game = new BaseBallGame();
		game.startGame();

	}
}
