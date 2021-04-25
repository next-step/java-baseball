package baseball.view;

import baseball.controller.dto.GuessFeedbackResponse;

public interface BaseballOutput {
	void returnGuessFeedbackResponse(GuessFeedbackResponse response);
}
