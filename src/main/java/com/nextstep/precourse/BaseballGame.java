package com.nextstep.precourse;

import com.nextstep.precourse.computer.Computer;
import com.nextstep.precourse.user.User;

public class BaseballGame {
	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.start();
	}

	public void start() {
		Computer computer = new Computer();
		User user = new User();

		boolean isInTheGame = true;
		while (isInTheGame) {
			computer.ready();
			progress(computer, user);
			isInTheGame = user.selectMenu();
		}
	}

	private void progress(Computer computer, User user) {
		boolean isInTheGame = true;
		while (isInTheGame) {
			String userAnswer = user.receiveAnswer();
			isInTheGame = computer.checkAnswer(userAnswer) ? false : true;
		}
	}
}
