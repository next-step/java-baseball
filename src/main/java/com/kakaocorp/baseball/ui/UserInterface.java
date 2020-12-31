package com.kakaocorp.baseball.ui;

import java.util.Scanner;

public class UserInterface {
    private Scanner inputScanner;
    private int nextInput;

    public UserInterface() {
        inputScanner = new Scanner(System.in);
    }

    public int scanNextGuessingNum() {
        scanNextInt();

        return nextInput;
    }

    public boolean scanPlayerWantsToEnd() {
        scanNextInt();

        return playerWantsToEnd();
    }

    public void printFinishGameAskingMessage() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
    }

    public void printNextPlayerPickMessage() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public void printStatusMessageStrikesBalls(int strikes, int balls) {
        if (noCorrectGuessStrikesBalls(strikes, balls)) {
            System.out.println("꽝!");
            return;
        }

        if (hasAtLeastOne(strikes)) {
            System.out.print(Integer.toString(strikes) + " 스트라이크");
        }

        if (hasAtLeastOne(balls)) {
            printWhiteSpaceDelimiterIfThereAre(strikes);
            System.out.print(Integer.toString(balls) + " 볼");
        }
        System.out.println();
    }

    private void scanNextInt() {
        nextInput = inputScanner.nextInt();
    }

    private boolean playerWantsToEnd() {
        return nextInput == 2;
    }

    private boolean noCorrectGuessStrikesBalls(int strikes, int balls) {
        boolean noStrikes = (strikes == 0);
        boolean noBalls = (balls == 0);
        return noStrikes && noBalls;
    }

    private boolean hasAtLeastOne(int value) {
        return value >= 1;
    }

    private void printWhiteSpaceDelimiterIfThereAre(int value) {
        if (hasAtLeastOne(value)) {
            System.out.print(" ");
        }
    }
}
