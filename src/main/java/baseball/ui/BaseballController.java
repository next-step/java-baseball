package baseball.ui;

import baseball.application.BaseballService;
import baseball.dto.Request;
import baseball.dto.Response;

public class BaseballController {
    private final BaseballService baseballService;

    public BaseballController(final BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public Response play(Request request) {
        return baseballService.play(request);
    }
}
