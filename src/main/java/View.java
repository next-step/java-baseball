import java.util.Scanner;

public class View {
	private final Scanner scanner;

	public View() {
		this.scanner = new Scanner(System.in);
	}

	public String inputAnswerNumber() {
		System.out.print(Constants.INPUT_ANSWER);
		return scanner.next();
	}

	public int selectGameMenu() {
		System.out.println(Constants.GAME_MENU_SELECTION);
		return scanner.nextInt();
	}

	public void printEvaluation(int strikeCount, int ballCount) {
		String displayString = checkStrikeNumber(strikeCount) +
				checkBallNumber(ballCount) +
				checkNothing(strikeCount, ballCount) +
				"\n" +
				checkHitAnswer(strikeCount);

		System.out.println(displayString);
	}

	private String checkNothing(int strikeCount, int ballCount) {
		if (strikeCount == 0 && ballCount == 0) {
			return Constants.NOTHING;
		}
		return "";
	}

	private String checkHitAnswer(int strikeCount) {
		if (strikeCount == 3) {
			return Constants.HIT_ANSWER;
		}
		return "";
	}

	private String checkStrikeNumber(int strikeCount) {
		if (strikeCount > 0) {
			return strikeCount + Constants.STRIKE;
		}
		return "";
	}

	private String checkBallNumber(int ballCount) {
		if (ballCount > 0) {
			return ballCount + Constants.BALL;
		}
		return "";
	}
}
