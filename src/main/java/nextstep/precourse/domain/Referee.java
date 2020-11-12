package nextstep.precourse.domain;

public class Referee {
    public static GameResult judge(BallNumbers computerBallNumbers, BallNumbers userBallNumbers) {
        int strike = 0;
        int ball = 0;

        for(int i = 1; i <= 3; i++) {
            strike += isStrike(computerBallNumbers, userBallNumbers, i);
            ball += isBall(computerBallNumbers, userBallNumbers, i);
        }

        return new GameResult(strike, ball);
    }

    public static int isStrike(BallNumbers computerBallNumbers, BallNumbers userBallNumbers, int index) {
        if(computerBallNumbers.getNumberByPosition(index) == userBallNumbers.getNumberByPosition(index)) {
            return 1;
        }
        return 0;
    }

    public static int isBall(BallNumbers computerBallNumbers, BallNumbers userBallNumbers, int index) {
        if(isStrike(computerBallNumbers, userBallNumbers, index) == 1) {
            return 0;
        }

        if(computerBallNumbers.isContain(userBallNumbers.getNumberByPosition(index))) {
            return 1;
        }
        return 0;
    }
}
