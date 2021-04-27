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
	private String ballStrikeCountMessage(FootballMatchResult matchResult) {
		assert false;
		return null;
	}

	private void print(String message) {
		System.out.println(message);
	}

}
