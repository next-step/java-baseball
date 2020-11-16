import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameRule {

    private final int ANSWER_LENGTH = 3;

    // 1 - 9 Answer Keyword
    private List<String> reservedNumberSet;
    private String gameAnswer;

    private AnswerRule answerRule;

    public void initAnswer() {
        setReservedNumberSet();
        setAnswer();

        answerRule = new AnswerRule();
    }

    private void setAnswer() {
        gameAnswer = "";
        final List<String> answerKeyword = new ArrayList<>(reservedNumberSet);
        for(int i = 0; i < ANSWER_LENGTH; i++) {
            int index = new Random().nextInt(answerKeyword.size());
            gameAnswer += answerKeyword.get(index);
            answerKeyword.remove(index);
        }
    }

    private void setReservedNumberSet() {
        reservedNumberSet = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            reservedNumberSet.add(String.format("%d", i));
        }
    }

    public boolean isAnswer(String userAnswer) {
        if(!answerRule.isValidate(userAnswer)) {
            return false;
        }

        return checkStrikeAndBall(userAnswer);
    }

    private boolean checkStrikeAndBall(String userAnswer) {
        GameRuleStrike gameRuleStrike = new GameRuleStrike(gameAnswer, userAnswer);
        if(gameRuleStrike.isThreeStrike()) {
            return true;
        }
        GameRuleBall gameRuleBall = new GameRuleBall(gameAnswer, userAnswer);
        displayHint(gameRuleStrike, gameRuleBall);
        return false;
    }

    public void displayHint(GameRuleStrike gameRuleStrike, GameRuleBall gameRuleBall) {
        String hint = "";
        if(!gameRuleStrike.isThreeStrike() && gameRuleStrike.getStrike() > 0) {
            hint += String.format("%s ", gameRuleStrike.getHint());
        }

        if(gameRuleBall.getBall() > 0 ) {
            hint += String.format(gameRuleBall.getHint());
        }

        System.out.println(hint);
    }

    public List<String> getReservedNumberSet() {
        return reservedNumberSet;
    }

    public String getGameAnswer() {
        return gameAnswer;
    }
}
