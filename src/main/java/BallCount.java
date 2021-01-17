import java.util.List;

public class BallCount {

    private final int balls;
    private final int strikes;

    private final String EMPTY_STRING = "";

    public BallCount(Numbers numbers1, Numbers numbers2) {
        List<Integer> answerNumbers = numbers1.getNumbers();
        List<Integer> anotherNumbers = numbers2.getNumbers();
        int balls = 0;
        int strikes = 0;
        int count = answerNumbers.size();
        for (int i = 0; i < count; i++) {
            if (answerNumbers.get(i).equals(anotherNumbers.get(i))) {
                strikes++;
            } else if (anotherNumbers.contains(answerNumbers.get(i))) {
                balls++;
            }
        }

        this.balls = balls;
        this.strikes = strikes;
    }

    public void printDetailedCountMessage() {
        System.out.println(createBallCountMessage(this.balls, this.strikes));
    }

    private String createBallCountMessage(int balls, int strikes) {
        if (isNoCount(balls, strikes)) {
            return BallCountMessage.NOTHING.toString();
        }
        String ballString = createBallString(balls);
        String strikeString = createStrikeString(strikes);
        return (ballString + " " + strikeString).trim();
    }

    private boolean isNoCount(int balls, int strikes) {
        return balls == 0 && strikes == 0;
    }

    private String createBallString(int balls) {
        if (balls <= 0) {
            return EMPTY_STRING;
        }
        return balls + BallCountMessage.BALL.toString();
    }

    private String createStrikeString(int strikes) {
        if (strikes <= 0) {
            return EMPTY_STRING;
        }
        return strikes + BallCountMessage.STRIKE.toString();
    }

    public boolean isThreeStrikes() {
        return this.strikes == 3;
    }
}
