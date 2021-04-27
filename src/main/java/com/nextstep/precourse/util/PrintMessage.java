package com.nextstep.precourse.util;

import com.nextstep.precourse.baseballgame.GenerateResult;
import com.nextstep.precourse.computer.BaseBallResult;

public class PrintMessage {

	private GenerateResult generateResult = new GenerateResult();

	public void printMessage(BaseBallResult result) {
		System.out.println(generateResult.getResult(result));
	}

	public boolean printGameOver() {
		System.out.println(PrintMessageEnum.RESTART_GAME.getMessage());
		return generateResult.isGameOver();
	}

	public void printThreeStrike(boolean progressStatus) {
		if (!progressStatus){
			System.out.println(PrintMessageEnum.GOT_RIGHT_ANSWER.getMessage());
		}
	}
}
