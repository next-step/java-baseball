package NumberBaseBallGame;

public class PlayGame {
	private final char[] gameNumbers;

	public PlayGame() {
		gameNumbers = new GenerateGameNumber().generateGameNumber();
	}
	public GameHintAndResults insertNumbers(String numbers){
		GameHintAndResults result = new GameHintAndResults();
		return result;
	}
}
