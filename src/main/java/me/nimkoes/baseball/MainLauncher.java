package me.nimkoes.baseball;

import me.nimkoes.baseball.controller.BaseballController;
import me.nimkoes.baseball.view.CommandLine;

public class MainLauncher {

    public static final int LENGTH_OF_NUMBER = 3;

    public static void main(String[] args) {
        BaseballController controller = new BaseballController(CommandLine.getInstance());
        controller.run();
    }
}
