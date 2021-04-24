import java.util.List;

import data.BaseballGameHint;
import data.BaseballNumbers;

public class BaseballNumberChecker {

	public BaseballGameHint getHint(BaseballNumbers userInput, BaseballNumbers computerAnswer) {
		List<Integer> userNumbers = userInput.getNumbers();
		List<Integer> computerNumbers = computerAnswer.getNumbers();

		BaseballGameHint hint = new BaseballGameHint();

		for(int i=0; i<userNumbers.size(); i++) {
			judge(userNumbers, computerNumbers, i, hint);
		}
		return hint;
	}

	private void judge(List<Integer> userNumbers, List<Integer> computerNumbers, int idx, BaseballGameHint hint) {
		if(userNumbers.get(idx).equals(computerNumbers.get(idx))) {
			hint.addStrike();
			return;
		}
		if(computerNumbers.contains(userNumbers.get(idx))) {
			hint.addBall();
		}
	}


}
