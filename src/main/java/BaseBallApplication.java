public class BaseBallApplication {
	public static void main(String[] args) {
		int gameCode = BaseBallGame.GameContinueCode;
		while (gameCode != BaseBallGame.GameExitCode) {
			// 랜덤 숫자 생성
			int[] target = BaseBallGame.getRandomNumber3Length();
			BaseBallGame.start(target);
			// 게임 계속 여부 판단
			gameCode = BaseBallGame.getGameCode();
		}
	}
}