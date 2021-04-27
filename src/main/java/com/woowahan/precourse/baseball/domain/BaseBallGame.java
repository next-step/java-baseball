package com.woowahan.precourse.baseball.domain;

import com.woowahan.precourse.baseball.GameResult;
import com.woowahan.precourse.baseball.record.BaseBallRecord;
import com.woowahan.precourse.baseball.rule.BaseBallRule;
import com.woowahan.precourse.baseball.view.GameMessage;

public class BaseBallGame {

    private final String[] gameNumbers;  // 컴퓨터가 선택한 세자리 수 - Game 생성 시 같이 생성되어야 함.
    private String[] inputNumbers;
    private BaseBallRecord baseBallRecord;
    private GameResult gameResult;

    public BaseBallGame() {
        this.gameNumbers = createBallGameNumber();
        this.gameResult = new GameResult();
    }

    public String[] getGameNumber() {
        return gameNumbers;
    }

    private String generateRandomNumber() {
        return String.valueOf((int) (Math.random() * 9 + 1));
    }

    private String[] createBallGameNumber() {

        String firstNumber = generateRandomNumber();
        String secondNumber = "";
        String thirdNumber = "";

        do {
            secondNumber = generateRandomNumber();
        } while (firstNumber.equals(secondNumber));

        do {
            thirdNumber = generateRandomNumber();
        } while (secondNumber.equals(thirdNumber) || firstNumber.equals(thirdNumber));

        return new String[] { firstNumber, secondNumber, thirdNumber };
    }

    public GameResult execute(String[] inputNumbers) {

        baseBallRecord = new BaseBallRecord();

        this.inputNumbers = inputNumbers;

        for(int position = 0; position < 3; position++) {
            countStrike(position);
            countBall(position);
        }

        int strikeCount = baseBallRecord.getStrikeCount();
        int ballCount = baseBallRecord.getBallCount();

        if (BaseBallRule.isNothingAndFourBall(strikeCount, ballCount)) {
            this.gameResult.setMessage(GameMessage.NOTHING);
            return this.gameResult;
        }

        if (BaseBallRule.isVictory(strikeCount)) {
            this.gameResult.setVictory(true);
            this.gameResult.setMessage(GameMessage.VICTORY);
            return this.gameResult;
        }

        StringBuilder sb = new StringBuilder();

        if (strikeCount > 0) {
            this.gameResult.setMessage(sb.append(strikeCount).append(GameMessage.STRIKE).toString());
        }

        if (ballCount > 0) {
            this.gameResult.setMessage(sb.append(ballCount).append(GameMessage.BALL).toString());
        }

        return this.gameResult;
    }

    private void countBall(int position) {
        if (BaseBallRule.isBall(this.gameNumbers, this.inputNumbers[position], position)) {
            baseBallRecord.doBall();
        }
    }

    private void countStrike(int position) {
        if (BaseBallRule.isStrike(this.gameNumbers[position], this.inputNumbers[position])) {
            baseBallRecord.doStrike();
        }
    }
}
