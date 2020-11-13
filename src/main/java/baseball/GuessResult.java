package baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
public class GuessResult {
	private static final String FOUR_BALL_MESSAGE_FORMAT = "포볼";
	private static final String STRIKE_MESSAGE_FORMAT = "%d 스트라이크";
	private static final String BALL_MESSAGE_FORMAT = "%d 볼";
	private static final String DELIMITER = " ";

	private int strikeCount;
	private int ballCount;

	GuessResult(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	String getMessage() {
		if (strikeCount == 0 && ballCount == 0) {
			return FOUR_BALL_MESSAGE_FORMAT;
		}

		List<String> messages = new ArrayList<>();
		addMessage(messages, strikeCount, STRIKE_MESSAGE_FORMAT);
		addMessage(messages, ballCount, BALL_MESSAGE_FORMAT);
		return String.join(DELIMITER, messages);
	}

	private void addMessage(List<String> messages, int count, String messageFormat) {
		if (count > 0) {
			String message = String.format(messageFormat, count);
			messages.add(message);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		GuessResult guessResult = (GuessResult)obj;
		return this.strikeCount == guessResult.strikeCount && this.ballCount == guessResult.ballCount;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return String.format("strikeCount=%d, ballCount=%d", strikeCount, ballCount);
	}
}
