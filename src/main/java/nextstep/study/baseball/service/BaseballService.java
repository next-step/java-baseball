package nextstep.study.baseball.service;

import nextstep.study.baseball.common.BaseConstants;
import nextstep.study.baseball.domain.Batter;
import nextstep.study.baseball.domain.DecisionResult;
import nextstep.study.baseball.domain.Pitcher;
import nextstep.study.baseball.domain.Referee;
import nextstep.study.baseball.util.BaseballUtil;

import java.util.Scanner;

public class BaseballService {
	private Referee referee;

	public BaseballService() {
		referee = new Referee();
	}

	public BaseballService(Referee referee) {
		this.referee = referee;
	}

	public void playBall() {
		Batter batter = new Batter();
		Pitcher pitcher = new Pitcher();

		this.playBall(batter, pitcher);
	}

	public void playBall(Batter batter, Pitcher pitcher) {
		DecisionResult decisionResult = null;

		do {
			pitcher.makeMixBallNumber(); // 투수 볼배합 만들기 (입력받기)
			decisionResult = referee.makeDecisionResult(batter.getNumbers(), pitcher.getNumbers());
			this.showDecisionMessage(decisionResult);
		} while (!referee.isOut(decisionResult));

		askFinish();
	}

	public void showDecisionMessage(DecisionResult decision) {
		if (decision.getStrikeCount() > 0) {
			BaseballUtil.showMessage(String.format("%d 스트라이크 ", decision.getStrikeCount()));
		}
		if (decision.getBallCount() > 0) {
			BaseballUtil.showMessage(String.format("%d 볼 ", decision.getBallCount()));
		}
		if (decision.getStrikeCount() == 0 && decision.getBallCount() == 0) {
			BaseballUtil.showMessage("낫싱");
		}
		BaseballUtil.showMessage("\n");
	}

	public void askFinish() {
		this.askFinish(BaseConstants.FINISH_STRIKE_OUT + BaseConstants.MESSAGE_FINISH);
	}

	public void askFinish(String message) {
		if (message == null && message.length() == 0) {
			message = BaseConstants.FINISH_STRIKE_OUT + BaseConstants.MESSAGE_FINISH;
		}
		BaseballUtil.showMessage(message);
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		if (inputStr.equals("1")) {
			this.playBall();
		}
	}

}
