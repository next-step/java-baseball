public class BaseBallDto {
    public static class Result {
        private boolean isAnswer;
        private int strike;
        private int ball;

        public Result(boolean isAnswer, int strike, int ball) {
            this.isAnswer = isAnswer;
            this.strike = strike;
            this.ball = ball;
        }

        public boolean getIsAnswer() {
            return isAnswer;
        }

        public int getStrike() {
            return strike;
        }

        public int getBall() {
            return ball;
        }
    }
}
