package io.chikeem90.github;

import java.util.List;

import io.chikeem90.github.service.BaseballCounter;
import io.chikeem90.github.service.InOutputUtil;
import io.chikeem90.github.service.NumberGenerator;

public class BaseballGame {
	public void startBaseballGame(NumberGenerator numberGenerator) {
		BaseballCounter baseballCounter = new BaseballCounter();
		boolean isContinue = true;
		while (isContinue) {
			List<Character> generatedNumber = numberGenerator.generateNumber();
			baseballCounter.processCount(generatedNumber);
			isContinue = this.getIsContinue(InOutputUtil.getOptionVal());
		}
	}

	private boolean getIsContinue(String option) {
		return option.equals("1");
	}
}
