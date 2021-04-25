package me.nimkoes.baseball;

import me.nimkoes.baseball.controller.BaseballController;
import me.nimkoes.baseball.model.RandomNumberRepository;
import me.nimkoes.baseball.service.BaseballService;
import me.nimkoes.baseball.view.CommandLine;

public class MainLauncher {

    public static final int LENGTH_OF_NUMBER = 3;

    public static void main(String[] args) {
        BaseballService baseballService = new BaseballService(RandomNumberRepository.getInstance());
        BaseballController controller = new BaseballController(CommandLine.getInstance(), baseballService);
        controller.run();
    }
}
