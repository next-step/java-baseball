package me.lozm.baseball;

import me.lozm.baseball.service.BaseballGameService;

public class BaseballGameApp {

    public static void main(String[] args) {
        BaseballGameService baseballGameService = new BaseballGameService();
        baseballGameService.run();
    }

}