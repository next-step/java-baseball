package com.ascii92der.baseball;

import com.ascii92der.baseball.game.Baseball;
import com.ascii92der.baseball.ui.InputUI;
import com.ascii92der.baseball.ui.OutputUI;

public class BaseballGame {

    private InputUI inputUI;
    private Baseball baseball;

    public BaseballGame() {
        inputUI = new InputUI();
    }

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.start();
    }

    public void start() {
        boolean isGameEnd = false;
        baseball = new Baseball();
        while (!isGameEnd) {
            String playerInput = inputUI.inputNumber();
            baseball.getPlayer().setPlayerList(playerInput);
            isGameEnd = baseball.resultBaseball(baseball.getComputer().getNumberList(), baseball.getPlayer().getNumberList());
        }
        if (inputUI.inputCommand().equals("1")) {
            start();
        }
    }
}
