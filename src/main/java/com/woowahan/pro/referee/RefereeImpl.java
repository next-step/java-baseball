package com.woowahan.pro.referee;

public class RefereeImpl implements Referee{
    private int strike;
    private int ball;

    public RefereeImpl(){}

    public RefereeImpl(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    private void init() {
        strike = 0;
        ball = 0;
    }

    @Override
    public GameStatus judge(String[] opponentNumbers, String[] playerNumbers) {
        init();

        for(int i=0; i<playerNumbers.length; i++) {
            judgeStrike(opponentNumbers[i], playerNumbers[i]);
            judgeBall(opponentNumbers, playerNumbers[i], i);
        }

        return getStatus();
    }

    private GameStatus getStatus() {
        if(getStrike() == 3) {
            return GameStatus.SUCCESS;
        }

        return GameStatus.FAIL;
    }

    /**
     * 볼 판단
     * 1. 상대방이 낸 숫자들에 플레이어가 낸 숫자가 포함되어 있는지 판단.
     * 2. 포함되어 있으면 해당 숫자의 상대방의 위치와 플레이어의 위치가 같은지 판단.(같으면 볼이 아님 -> 스트라이크)
     * @param opponentNumbers
     * @param playerNumber
     * @param index
     */
    private void judgeBall(String[] opponentNumbers, String playerNumber, int index) {
        String temp = String.join("", opponentNumbers);
        if(temp.contains(playerNumber) && temp.indexOf(playerNumber) != index) {
            plusBall();
        }
    }

    /**
     * 스트라이크 판단
     * @param opponentNumber
     * @param playerNumber
     */
    private void judgeStrike(String opponentNumber, String playerNumber) {
        if(opponentNumber.equals(playerNumber)) {
            plusStrike();
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private void plusStrike() {
        strike++;
    }

    private void plusBall() {
        ball++;
    }
}
