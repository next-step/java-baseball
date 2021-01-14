package domain;

import util.PrintUtil;
import util.RandomNumberUtil;
import util.ValidationUtil;

import java.util.Scanner;

public class BaseballGame {
    public static final int INPUT_NUMBER_SIZE = 3;

    public void play(Scanner scanner) {
        initPrint();
        int[] userInput = Player.getPlayerInput(scanner);
        int[] systemNum = RandomNumberUtil.getDistinctNumber();
    }

    private void initPrint() {
        PrintUtil.printInfo();
    }

}