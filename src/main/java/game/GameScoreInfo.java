package game;

import common.GameGuidePhrases;
import common.GameOption;

public class GameScoreInfo {
    private int strikeCount;
    private int ballCount;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void addOneStrikeCount() {
        this.strikeCount++;
    }

    public void addOneBallCount() {
        this.ballCount++;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public String makeScoreResultString() {
        StringBuilder resultStringBuilder = new StringBuilder();

        if (this.getStrikeCount() == GameOption.RANDOM_NUMBER_COUNT) {
            resultStringBuilder.append(GameGuidePhrases
                    .SUCCESS
                    .replaceAll("\\{\\}",String.valueOf(GameOption.RANDOM_NUMBER_COUNT)));
            return resultStringBuilder.toString();
        }

        if (this.getStrikeCount() == 0 && this.getBallCount() == 0) {
            resultStringBuilder.append(GameGuidePhrases.FAIL);
            return resultStringBuilder.toString();
        }

        if (this.getStrikeCount() > 0) {
            resultStringBuilder.append(this.getStrikeCount());
            resultStringBuilder.append(GameGuidePhrases.DELIMETER);
            resultStringBuilder.append(GameGuidePhrases.STRIKE);
            resultStringBuilder.append(GameGuidePhrases.DELIMETER);
        }

        if (this.getBallCount() > 0) {
            resultStringBuilder.append(this.getBallCount());
            resultStringBuilder.append(GameGuidePhrases.BALL);
        }

        return resultStringBuilder.toString().trim();
    }
}
