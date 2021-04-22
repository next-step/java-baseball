package nextstep.study.baseball.service;

import nextstep.study.baseball.domain.Batter;
import nextstep.study.baseball.domain.Pitcher;
import nextstep.study.baseball.domain.Referee;
import nextstep.study.baseball.domain.RefreeDecision;

public class BaseballService {

	public void playBall() {
		Batter batter = new Batter();
		batter.generateRandomNumbers();

		int strikeCount = 0;

		while (strikeCount < 3) {
			Pitcher pitcher = new Pitcher();
			pitcher.makeMixBallNumber(); // 투수 볼배합 만들기 (입력받기)

			RefreeDecision decision = Referee.makeRefreeDecision(batter.getNumbers(), pitcher.getNumbers());
			strikeCount = decision.getStrikeCount();

			System.out.println("타자 : " + batter.getNumbers());
			System.out.println("투수 : " + pitcher.getNumbers());
			System.out.println("strikeCount : " + strikeCount);
		}
	}

}
