package baseball.players.player;

import java.util.List;

public interface Player {
	List<Integer> getRequestNumbers();

	boolean isContinue();

	enum RestartCommand {
		CONTINUE("1"),
		EXIT("2");

		String code;

		RestartCommand(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}
	}
}
