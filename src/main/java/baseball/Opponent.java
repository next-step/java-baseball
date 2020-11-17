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
        gameResults = new GameResults();
        judgeStrike(playerValue);
        judgeBall(playerValue);
        finishGame();
    }

    private void finishGame() {
        gameResults.finish();
    }

    private void judgeStrike(String playerValue) {
        for (int i = 0; i < playerValue.length(); i++) {
            checkStrike(playerValue.charAt(i), value.charAt(i));
        }
    }

    private void checkStrike(char playerValue, char value) {
        if (playerValue == value) {
            gameResults.increaseStrike();
        }
    }

    public int getStrikeCnt() {
        return gameResults.getStrike();
    }

    private void judgeBall(String playerValue) {
        for (int i = 0; i < playerValue.length(); i++) {
            checkBall(i, playerValue.charAt(i));
        }
    }

    private void checkBall(int i, char charAt) {
        for (int j = 0; j < 3; j++) {
            if (j == i) {
                continue;
            }
            if (charAt == value.charAt(j)) {
                gameResults.increaseBall();
            }
        }
    }

    public int getBallCnt() {
        return gameResults.getBall();
    }

    public int getNothingCnt() {
        return gameResults.getNothing();
    }

    public void printGameResult() {
        String gameResult = gameResults.getGameResult();
        System.out.println(gameResult);
    }

    public boolean isUserCorrect() {
        return gameResults.getStrike() == 3;
    }
}
