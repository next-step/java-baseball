package com.woowahan.pro.ui;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private final Scanner scanner = new Scanner(System.in);

    public String input() {
        return scanner.nextLine();
    }

    public void output(String message) {
        System.out.print(message);
    }

    @Override
    public String[] requireNumbers() {
        output(Message.REQUIRE_NUMBERS);
        String[] playerNumbers = input().split("");
        return playerNumbers;
    }

    @Override
    public void outputOnFinishGame() {
        output(Message.GAME_DONE);
    }

    @Override
    public String inputRetry() {
        return input();
    }

    @Override
    public void outputScore(int strike, int ball) {
        StringBuilder result = new StringBuilder();
        if (strike > 0) {
            result.append(strike + " " + Message.STRIKE + " ");
        }
        if (ball > 0) {
            result.append(ball + " " + Message.BALL);
        }
        if (result.length() == 0) {
            result.append(Message.NOTHING);
        }
        output(result + "\n");
    }

    @Override
    public void close() {
        scanner.close();
    }
}
