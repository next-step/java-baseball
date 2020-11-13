package baseball;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
public class Main {
	private static NextStepType nextStepType = null;

	public static void main(String[] args) {
		while (nextStepType != NextStepType.EXIT) {
			Game game = new Game();
			nextStepType = game.start();
		}
	}
}
