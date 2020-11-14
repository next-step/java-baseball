package baseball.application;

import baseball.domain.BaseBallGenerator;
import baseball.domain.BaseballNumbers;
import baseball.dto.Request;
import baseball.dto.Response;

public class BaseballService {
    private final BaseballNumbers target;

    public BaseballService(final BaseBallGenerator baseBallGenerator) {
        target = baseBallGenerator.generate();
    }

    public Response play(Request request) {
        BaseballNumbers playerNumber = BaseballNumbers.from(request.getNumber());
        return Response.from(target.match(playerNumber));
    }
}
