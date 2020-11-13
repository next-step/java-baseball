package nextstep.precourse.domain;

import nextstep.precourse.RandomBallNumberGenerator;

public class BaseballGame {
    private BallNumbers computerBallNumbers;

    public GameResult play(BallNumbers userBallNumbers) {
        return Referee.judge(computerBallNumbers, userBallNumbers);
    }

    public void init() {
        computerBallNumbers = RandomBallNumberGenerator.generate();
    }

    public void exit() {
        System.exit(0);
    }
}
