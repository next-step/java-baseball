package study.baseball;

import study.baseball.controller.BaseBallGameController;
import study.baseball.service.NumberGenerator;
import study.baseball.service.ResultChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BaseBallGameApplication {

    public static void main(String[] args) {
        BaseBallGameController baseballGame = new BaseBallGameController();
        baseballGame.gameStart();
    }

}
