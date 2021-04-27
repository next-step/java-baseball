package com.baseball.game;

import java.util.Scanner;

import com.baseball.message.UIMessage;

public class BaseBallGame {

	boolean onGame = true;

	public void startGame() {
		while (onGame) {
			BaseBallInning baseBallInning = new BaseBallInning();

			baseBallInning.onInning();

			//게임 재개 여부 확인
			askResume();
		}
	}

	private void askResume() {
		System.out.println(UIMessage.RESUME_INFO);

		Scanner scanner = new Scanner(System.in);
		String resumeText = scanner.nextLine();

		if ("1".equals(resumeText)) {
			onGame = true;
		}
		if ("2".equals(resumeText)) {
			onGame = false;
		}
	}
}
