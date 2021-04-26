package com.nextstep.precourse.baseballgame;

import com.nextstep.precourse.computer.BaseBallResult;
import com.nextstep.precourse.computer.Referee;
import com.nextstep.precourse.computer.Ball;
import com.nextstep.precourse.user.User;
import com.nextstep.precourse.util.PrintMessage;

public class BaseBallGame {
	private final Ball ball = new Ball();
	private final User user = new User();
	private final Referee referee = new Referee();
	private final GenerateResult generateResult = new GenerateResult();
	private final PrintMessage printMessage = new PrintMessage();

	public void runGame() {
		do {
			ball.makeRandomlyThreeDigitAnswer();
			startGame();
		} while (printMessage.isGameOver());
	}

	private void startGame() {
		boolean progressStatus = true;
		while (progressStatus) {
			String userInput = user.getUserInputNumber();
			BaseBallResult baseBallResult = referee.getResult(ball.getAnswerList(), userInput);
			printMessage.printMessage(baseBallResult);
			progressStatus = generateResult.isCountinue(baseBallResult.getStrikeCount());
			printMessage.printThreeStrike(progressStatus);
			referee.initCount();
		}
	}
}
