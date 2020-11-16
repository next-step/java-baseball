package baseball;

public class Opponent {

    private String value;
    private GameResults gameResults;

    public Opponent() {
        value = "";
        gameResults = new GameResults();
    }

    public Opponent(String value) {
        this.value = value;
        gameResults = new GameResults();
    }

    public void selectValue() {
        NumberGenerator numberGenerator = new NumberGenerator();

        for (int i = 0; i < 3; i++) {
            Integer randomNumber = numberGenerator.getRandomNumber();
            this.value = this.value.concat(randomNumber.toString());
        }

    }

    public String getValue() {
        return value;
    }

    public void judgeGame(String playerValue) {
        judgeStrike(playerValue);

    }

    private void judgeStrike(String playerValue) {
        for (int i = 0; i < playerValue.length(); i++) {
            compareChar(playerValue.charAt(i), value.charAt(i));
        }
    }

    private void compareChar(char playerValue, char value) {
        if (playerValue == value) {
            gameResults.increaseStrike();
        }
    }

    public int getStrikeCnt() {
        return gameResults.getStrike();
    }
}
