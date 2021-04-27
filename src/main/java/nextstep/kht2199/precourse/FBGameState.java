package nextstep.kht2199.precourse;

/**
 * 게임의 상태({@link FBGameState}) 따른 기능을 처리한다.
 *
 * 변경사항이 발생되면 게임정보{@link FBGame}를 관리하는 객체에 메시지를 전달한다.
 *
 * 최초 상태는 INITIATED, 이후 사용자의 input에 대한 결과에 따라 상태가 유지되거나 ON_GOING, ENDED로 변경된다.
 *
 * @author heetaek.kim
 */
public enum FBGameState {
	INITIATED{
		@Override
		public void handleUserResponse(FBGame fbGame, String response) {
			assert false;
		}

		@Override
		public String message() {
			assert false;
			return null;
		}
	},
	ON_GOING{
		/**
		 * Computer의 number와 일치하는지 여부를 확인
		 * 일치할 경우,
		 *
		 */
		@Override
		public void handleUserResponse(FBGame fbGame, String response) {
			assert false;
		}

		@Override
		public String message() {
			assert false;
			return null;
		}

	},
	ENDED{
		@Override
		public void handleUserResponse(FBGame fbGame, String response) {
			// no action.
		}

		@Override
		public String message() {
			assert false;
			return null;
		}
	},
	;

	/**
	 * 현재 상태에 따른
	 * 1. 입력의 유효성을 체크
	 * 2. 사용자의 입력 처리
	 *
	 * @param fbGame 게임 관리 기능, 게임 정보
	 * @param response 사용자의 응답
	 */
	public abstract void handleUserResponse(FBGame fbGame, String response);

	/**
	 *
	 * @return 현재 상태에 따른 사용자에게 노출 할 메시지
	 */
	public abstract String message();

}
