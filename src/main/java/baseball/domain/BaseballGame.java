package baseball.domain;

import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {

	public static void play() {
		BaseballNumbers autoBaseballNumbers = BaseballNumbers.newAutoBaseballNumbers();

		while (true) {
			BaseballNumbers inputBaseballNumbers = InputView.inputBaseballNumbers();
			BaseballGameMatchResult matchResult = autoBaseballNumbers.getBaseballGameMatchResult(inputBaseballNumbers);
			ResultView.printMatchResult(matchResult);
			if (matchResult.isAllMatch(BaseballNumberMatch.STRIKE)) {
				break;
			}
		}
	}

}
