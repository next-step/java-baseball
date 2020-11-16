public class GameRuleStrike {

    private final int ANSWER_LENGTH = 3;

    private String gameAnswer;
    private String userAnswer;

    private int strike;

    public GameRuleStrike(String gameAnswer, String userAnswer) {
        this.gameAnswer = gameAnswer;
        this.userAnswer = userAnswer;
        checkStrike();
    }

    private void checkStrike() {
        for(int i = 0 ; i < userAnswer.length(); i++) {
            setStrike(userAnswer.charAt(i), i);
        }
    }

    public boolean isThreeStrike() {
        return strike == ANSWER_LENGTH;
    }

    public boolean isNothing() {
        return strike == 0;
    }

    private void setStrike(char userAnswerToken, int index) {
        String userToken = String.valueOf(userAnswerToken);
        String answerToken = String.valueOf(gameAnswer.charAt(index));
        if(userToken.equals(answerToken)) {
            strike++;
        }
    }

    public String getHint() {
        if(isNothing()) {
            return "낫싱";
        }

        if(isThreeStrike()) {
            return "";
        }

        return String.format("%d 스트라이크", strike);
    }
}
