package playball.domain;

import java.util.ArrayList;
import java.util.List;

public enum Hint {

    STRIKE("스트라이크") {
        @Override
        public Integer calculateCount(Balls myBalls, Balls yourBalls) {
            int answer = 0;
            List<Ball> mine = myBalls.getBalls();
            List<Ball> yours = yourBalls.getBalls();

            for (int i = 0; i < mine.size(); i++) {
                answer += compareEachBall(mine.get(i), yours.get(i));
            }

            return answer;
        }

        private Integer compareEachBall(Ball mine, Ball your) {
            return mine.equals(your) ? 1 : 0;
        }
    },
    BALL("볼") {
        @Override
        public Integer calculateCount(Balls myBalls, Balls yourBalls) {
            int answer = 0;
            List<Ball> mine = myBalls.getBalls();
            List<Ball> yours = yourBalls.getBalls();

            for (int i = 0; i < mine.size(); i++) {
                answer += compareEachBall(mine.get(i), yours, i);
            }

            return answer;
        }

        private Integer compareEachBall(Ball mine, List<Ball> yours, int idx) {
            int answer = 0;
            for (int i = 0; i < yours.size(); i++) {
                answer += compareEachBallExceptMine(mine, idx, yours.get(i), i);
            }

            return answer;
        }

        private Integer compareEachBallExceptMine(Ball myBall, int myIdx, Ball yourBall, int yourIdx) {
            return (myIdx != yourIdx && myBall.equals(yourBall)) ? 1 : 0;
        }
    },
    NOTHING("낫싱") {
        @Override
        public Integer calculateCount(Balls myBalls, Balls yourBalls) {
            int answer = 0;
            List<Ball> mine = myBalls.getBalls();
            List<Ball> yours = yourBalls.getBalls();

            for (Ball ball : mine) {
                answer += compareEachBall(ball, yours);
            }

            return answer;
        }

        private Integer compareEachBall(Ball myBall, List<Ball> yours) {
            return !yours.contains(myBall) ? 1 : 0;
        }
    };

    private String description;

    Hint(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract Integer calculateCount(Balls myBalls, Balls yourBalls);

    public static HintResults calculateResults(Balls myBalls, Balls yourBalls) {
        List<HintResult> hintResults = new ArrayList<>();
        for (Hint hint : Hint.values()) {
            HintResult hintResult = HintResult.of(hint, hint.calculateCount(myBalls, yourBalls));
            hintResults.add(hintResult);
        }
        return HintResults.of(hintResults);
    }
}
