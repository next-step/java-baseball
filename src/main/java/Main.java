public class Main {
	public static void main(String[] args) {
		System.out.println("program started!");
		GameConfig gameConfig = new GameConfig(
			Constant.NUM_DIGIT, Constant.OPTION_MIN_NUM, Constant.OPTION_MAX_NUM);
		CandidateFactory candidateFactory = new CandidateFactory(gameConfig);
		BaseballGame baseballGame = new BaseballGame(candidateFactory);
		baseballGame.setDefensingUser(new ComputerUser());
		baseballGame.setOffensingUser(new HumanUser());
		baseballGame.start();
		System.out.println("program end!");
	}
}
