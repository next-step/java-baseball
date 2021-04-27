package nextstep.kht2199.precourse;

/**
 *
 * @author heetaek.kim
 */
public class FBGame {

	private FBGameState state;

	private FBGameNumber number;

	public FBGame() {
		init();
	}

	public void init() {
		state = FBGameState.INITIATED;
		number = new FBGameNumber();
	}

	/**
	 * 게임 시작
	 */
	public void start() {
		while(state != FBGameState.ENDED) {
			print(state.message());
			String response = acceptUserInput();
			state.handleUserResponse(this, response);
		}
	}

	/**
	 * 사용자의 숫자 비교한다.
	 *
	 * @param userNumber 사용자 입력 숫자
	 * @return 비교 결과
	 */
	private FootballMatchResult matchResult(int userNumber) {
		return number.match(userNumber);
	}

	private String acceptUserInput() {
		assert false;
		return null;
	}

	/**
	 * 사용자의 숫자 비교결과를 메시지로 변환한다.
	 *
	 * @param matchResult 숫자 비교 결과
	 * @return 결과에 따른 메시지
	 */
	protected String ballStrikeCountMessage(FootballMatchResult matchResult) {
		if (matchResult.matched) {
			return "3개의 숫자를 모두 맞히셨습니다! 게임 종료. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
		}
		if (matchResult.ball == 0 && matchResult.strike == 0) {
			return "낫싱";
		}
		if (matchResult.strike > 0 && matchResult.ball == 0) {
			return String.format("%d 스트라이크", matchResult.strike);
		}
		if (matchResult.strike == 0 && matchResult.ball > 0) {
			return String.format("%d 볼", matchResult.ball);
		}
		if (matchResult.strike > 0 && matchResult.ball > 0) {
			return String.format("%d 스트라이크 %d 볼", matchResult.strike, matchResult.ball);
		}
		throw new RuntimeException();
	}

	private void print(String message) {
		System.out.println(message);
	}

}
