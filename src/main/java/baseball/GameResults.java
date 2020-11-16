package baseball;

public class GameResults {

    private int strike;

    public GameResults() {
        this.strike = 0;
    }

    public void increaseStrike() {
        strike++;
    }


    private String getStrikeResults() {
        if (strike > 0) {
            return String.format("%d 스트라이크", strike);
        }

        return "";
    }

    public int getStrike() {
        return strike;
    }
}
