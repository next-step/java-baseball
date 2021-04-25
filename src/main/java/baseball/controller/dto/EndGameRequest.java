package baseball.controller.dto;

public class EndGameRequest {
	public enum Action {
		RESTART, END
	}

	private Action action;

	public EndGameRequest(Action action) {
		this.action = action;
	}

	public Action getAction() {
		return action;
	}
}
