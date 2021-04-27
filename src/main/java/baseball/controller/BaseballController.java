package baseball.controller;

import baseball.controller.dto.BaseballGameRequest;
import baseball.controller.dto.BaseballGameResponse;
import baseball.domain.BaseballGame;
import baseball.service.BaseballGameService;

public class BaseballController {

    private final BaseballGameService service;

    public BaseballController() {
        service = new BaseballGameService();
    }

    public void start() {
        service.start();
    }

    public BaseballGameResponse pitch(BaseballGameRequest request) {
        BaseballGame baseballGame = service.pitch(request.getPitchNumbers());
        return assembleResponse(baseballGame);
    }

    private BaseballGameResponse assembleResponse(BaseballGame baseballGame) {
        return new BaseballGameResponse(baseballGame.getStrikeCount(), baseballGame.getBallCount(), baseballGame.isNothing(), baseballGame.isFinish());
    }
}
