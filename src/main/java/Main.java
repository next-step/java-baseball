public class Main {
	public static void main(String[] args) {
		System.out.println("program started!");
		GameConfig gameConfig = new GameConfig(
			Configs.NUM_DIGIT, Configs.OPTION_MIN_NUM, Configs.OPTION_MAX_NUM);
		BaseballGame baseballGame = new BaseballGame(gameConfig);
		baseballGame.start();
		System.out.println("program end!");
	}
}
