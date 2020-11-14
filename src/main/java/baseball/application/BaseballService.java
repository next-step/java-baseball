package baseball.application;

import baseball.domain.BaseBallGenerator;
import baseball.domain.BaseballNumbers;
import baseball.dto.Request;
import baseball.dto.Response;

public class BaseballService {
    private final BaseBallGenerator baseBallGenerator;

    public BaseballService(final BaseBallGenerator baseBallGenerator) {
        this.baseBallGenerator = baseBallGenerator;
    }

    public Response play(Request request) {
        BaseballNumbers target = baseBallGenerator.generate();
        BaseballNumbers playerNumber = BaseballNumbers.from(request.getNumber());
        return Response.from(target.match(playerNumber));
    }
}
