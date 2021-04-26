package ttuop.nextstep.baseball;

import static ttuop.nextstep.baseball.Constants.*;

/**
 * 숫자야구 게임
 *
 * @author ttuop
 */
class Game {

	private final Referee referee;

	Game() {
		referee = new Referee(new AnswerGenerator().generate());
	}

	/**
	 * 사용자가 입력한 숫자와 정답을 비교해서 결과를 사용자에게 전송한다. 3 스트라이크가 나올 때까지 게임을 계속 진행한다.
	 */
	void play() {
		int strike = 0;

		while (isNotThreeStrike(strike)) {
			UserInterface.send(REQUEST_NUMBER_TO_USER_MESSAGE);
			final String input = UserInterface.receive();

			strike = referee.findStrike(input);
			final String message = RefereeCallResolver.getMessage(strike, referee.findBall(input));
			UserInterface.send(message);
		}
	}

	private boolean isNotThreeStrike(final int strike) {
		return strike != 3;
	}

}
