package com.nextstep.precourse.util;

import java.util.Scanner;

import com.nextstep.precourse.baseballgame.GenerateResult;
import com.nextstep.precourse.computer.BaseBallResult;

public class PrintMessage {

	private GenerateResult generateResult = new GenerateResult();

	public void printMessage(BaseBallResult result) {
		System.out.println(generateResult.getResult(result));
	}

	public boolean isGameOver() {
		System.out.println(PrintMessageEnum.RESTART_GAME.getMessage());
		Scanner scanner = new Scanner(System.in);
		int inputValue = scanner.nextInt();
		return inputValue == 1;
	}

	public void printThreeStrike(boolean progressStatus) {
		if (!progressStatus)
			System.out.println(PrintMessageEnum.GOT_RIGHT_ANSWER.getMessage());
	}
}
