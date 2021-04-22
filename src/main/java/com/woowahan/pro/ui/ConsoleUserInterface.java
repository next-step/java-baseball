package com.woowahan.pro.ui;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private static final String REQUIRE_NUMBERS = "숫자를 입력해주세요: ";
    private static final String GAME_DONE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public String input() {
        return scanner.nextLine();
    }

    public void output(String message) {
        System.out.print(message);
    }

    @Override
    public String[] requireNumbers() {
        output(REQUIRE_NUMBERS);
        String[] playerNumbers = input().split("");
        return playerNumbers;
    }

    @Override
    public void outputOnFinishGame() {
        output(GAME_DONE);
    }

    @Override
    public String inputRetry() {
        return input();
    }

    @Override
    public void outputScore(int strike, int ball) {
        StringBuilder result = new StringBuilder();
        if (strike > 0) {
            result.append(strike + " " + STRIKE + " ");
        }
        if (ball > 0) {
            result.append(ball + " " + BALL);
        }
        if (result.length() == 0) {
            result.append(NOTHING);
        }
        output(result + "\n");
    }

    @Override
    public void close() {
        scanner.close();
    }
}
