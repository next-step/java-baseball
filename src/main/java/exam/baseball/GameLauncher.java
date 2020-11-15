package exam.baseball;

public class GameLauncher {

	private static final int CODE_EXIT = 2;
	
	public static void main(String[] args) {
		Game game = new BaseBallGame(Utility::getRandom3Numbers);
		game.setInputMethod(BaseBallScanner::getBaseBallUserInput);
		game.setPrintMethod(msg->System.out.println(msg));

		do {
			game.start();	
		} while (retry());
		
		System.out.println("게임이 종료되었습니다. ");
	}
	
	private static boolean retry() {
		return GameLauncherScanner.getCodeForRetry() != CODE_EXIT;
	}
	
}
