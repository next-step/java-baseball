package nextstep.study.baseball.service;

import nextstep.study.baseball.common.BaseConstants;
import nextstep.study.baseball.domain.Batter;
import nextstep.study.baseball.domain.Pitcher;
import nextstep.study.baseball.domain.Referee;
import nextstep.study.baseball.domain.RefreeDecision;
import nextstep.study.baseball.util.BaseballUtil;

import java.util.Scanner;

public class BaseballService {

	public void playBall() {
		Batter batter = new Batter();
		batter.generateRandomNumbers();

		//TODO - 테스트 후 제거
		System.out.println(batter.getNumbers());

		int strikeCount = 0;

		while (strikeCount < 3) {
			Pitcher pitcher = new Pitcher();
			pitcher.makeMixBallNumber(); // 투수 볼배합 만들기 (입력받기)

			Referee referee = new Referee();
			RefreeDecision decision = referee.makeRefreeDecision(batter.getNumbers(), pitcher.getNumbers());
			strikeCount = decision.getStrikeCount();

			this.showDecisionMessage(decision);
		}
		askFinish();
	}

	public void showDecisionMessage(RefreeDecision decision) {
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
		BaseballUtil.showMessage(BaseConstants.MESSAGE_FINISH);
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		if (inputStr.equals("1")) {
			this.playBall();
		}
	}

}
