package basballgame.ui;

public class HintMessages {
	public static String STRIKE_TEXT = "%d 스트라이크";
	public static String BALL_TEXT = "%d볼";
	public static String STRIKE_AND_BALL_TEXT = STRIKE_TEXT + " " + BALL_TEXT;
	public static String NOTHING_TEXT = "낫싱";

	public static String strikeMessage(int strike) {
		return String.format(HintMessages.STRIKE_TEXT, strike);
	}
	public static String ballMessage(int ball) {
		return String.format(HintMessages.BALL_TEXT, ball);
	}
	public static String strikeAndBallMessage(int strike, int ball) {
		return String.format(HintMessages.STRIKE_AND_BALL_TEXT, strike, ball);
	}
}
