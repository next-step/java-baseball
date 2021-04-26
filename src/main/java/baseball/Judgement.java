package baseball;

import java.util.ArrayList;
import java.util.List;

class Judgement {
	private final int strikeCount;
	private final int ballCount;

	static class Builder {
		private final int strikeCount;
		private final int ballCount;

		Builder(int strikeCount, int ballCount) {
			this.strikeCount = strikeCount;
			this.ballCount = ballCount;
		}

		Judgement build() {
			return new Judgement(this);
		}
	}

	private Judgement(Builder builder) {
		this.strikeCount = builder.strikeCount;
		this.ballCount = builder.ballCount;

	}

	String toMessage() {
		List<String> messages = new ArrayList<>();

		addMessageOnCountGreaterThanZero(strikeCount, "%s 스트라이크", messages);
		addMessageOnCountGreaterThanZero(ballCount, "%s 볼", messages);

		if (!messages.isEmpty()) {
			return String.join(" ", messages);
		}

		return "낫싱";
	}

	boolean is3Strike() {
		return strikeCount == 3;
	}

	private void addMessageOnCountGreaterThanZero(int count, String format, List<String> messages) {
		if (count > 0) {
			String message = String.format(format, count);
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

		Judgement judgement = (Judgement)obj;
		return this.strikeCount == judgement.strikeCount && this.ballCount == judgement.ballCount;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
