package domain;

import util.PrintUtil;

import java.util.Scanner;

public class BaseballGame {

    public void play(Scanner scanner) {
        initPrint();
    }

    private void initPrint() {
        PrintUtil.printInfo();
    }

}