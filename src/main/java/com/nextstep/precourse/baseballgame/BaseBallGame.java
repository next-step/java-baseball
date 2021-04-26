package com.nextstep.precourse.baseballgame;

import java.util.Scanner;

import com.nextstep.precourse.computer.BaseBallResult;
import com.nextstep.precourse.computer.Referee;
import com.nextstep.precourse.computer.Ball;
import com.nextstep.precourse.util.PrintMessageEnum;
import com.nextstep.precourse.user.User;

public class BaseBallGame {
	private Ball ball;
	private User user;
	private Referee referee;
	private PrintMessage printMessage;

	public BaseBallGame() {
		this.ball = new Ball();
		this.user = new User();
		this.referee = new Referee();
		this.printMessage = new PrintMessage();
	}

	public void runGame() {
		do {
			ball.makeRandomlyThreeDigitAnswer();
			System.out.println(ball.getAnswerList());
			startGame();
		} while (isGameOver());
	}

	private void startGame() {
		boolean progressStatus = true;
		while (progressStatus) {
			String userInput = user.setUserInputNumberArray();
			BaseBallResult baseBallResult = referee.getResult(ball.getAnswerList(), userInput);
			System.out.println(printMessage.getResultString(baseBallResult));
			progressStatus = isThreeStrike(baseBallResult.getStrikeCount());
			referee.initCount();
		}
	}

	private boolean isThreeStrike(int strikeCount) {
		if (strikeCount == 3) {
			System.out.println(PrintMessageEnum.GOT_RIGHT_ANSWER.getMessage());
			return false;
		}
		return true;
	}

	private boolean isGameOver() {
		System.out.println(PrintMessageEnum.RESTART_GAME.getMessage());
		Scanner scanner = new Scanner(System.in);
		int inputValue = scanner.nextInt();
		return inputValue == 1;
	}
}
