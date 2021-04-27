package com.ascii92der.baseball.game;

import com.ascii92der.baseball.ui.Message;
import com.ascii92der.baseball.ui.OutputUI;

import java.util.List;

public class Baseball {

    private Computer computer;
    private Player player;

    public Baseball() {
        computer = new Computer();
        player = new Player();
    }

    public boolean resultBaseball(List<Integer> computerNumberList, List<Integer> userNumberList) {
        int ballCount = checkBallCount(computerNumberList, userNumberList);
        int strikeCount = checkStrikeCount(computerNumberList, userNumberList);
        ballCount = ballCount - strikeCount;

        String result = (strikeCount != 0 ? strikeCount + Message.RESULT_STRIKE : "") +
                (ballCount != 0 ? ballCount + Message.RESULT_BALL : "");
        OutputUI.resultMassage(result);
        if (strikeCount == 3) {
            OutputUI.resultMassage(Message.RESULT_GAME_END);
            return true;
        }
        return false;
    }

    public int checkBallCount(List<Integer> computerNumberList, List<Integer> userNumberList) {
        int index = 0;
        int ballCount = 0;
        while (index < 3) {
            ballCount = computerNumberList.contains(userNumberList.get(index)) ? ballCount + 1 : ballCount;
            index++;
        }
        return ballCount;
    }

    public int checkStrikeCount(List<Integer> computerNumberList, List<Integer> userNumberList) {
        int strikeCount = 0;
        for (int i = 0; i < computerNumberList.size(); i++) {
            strikeCount = computerNumberList.get(i).equals(userNumberList.get(i)) ? strikeCount + 1 : strikeCount;
        }
        return strikeCount;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
