public class GameRuleBall {
    private String gameAnswer;
    private String userAnswer;

    private int ball;

    public GameRuleBall(String gameAnswer, String userAnswer) {
        this.gameAnswer = gameAnswer;
        this.userAnswer = userAnswer;
        checkBall();
    }

    private void checkBall() {
        for(int i = 0 ; i < userAnswer.length(); i++) {
            setBall(userAnswer.charAt(i), i);
        }
    }

    private void setBall(char userAnswerToken, int index) {
        String userToken = String.valueOf(userAnswerToken);

        //스트라이크를 제외한 볼 판정을 할 수 있는 후보군
        String ballCandidate = gameAnswer.replace(String.valueOf(gameAnswer.charAt(index)), "");
        if(ballCandidate.contains(userToken)) {
            ball++;
        }
    }

    public String getHint() {
        if(ball == 0) {
            return "";
        }
        return String.format("%d 볼", ball);
    }
}
