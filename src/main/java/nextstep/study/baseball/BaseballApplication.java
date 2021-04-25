package nextstep.study.baseball;

import nextstep.study.baseball.service.BaseballService;

public class BaseballApplication {

	public static void main(String[] args) {
		BaseballService service = new BaseballService();
		service.playBall();
	}

}
