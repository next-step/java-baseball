package com.nextstep.baseball.handler;

import com.nextstep.baseball.enums.GameCode;

import java.util.Scanner;

public class GameUiHandler {

    public String getInput() {
        printInputMessage();

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void printInputMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public int printResultAndCheckContinue(int[] result) {
        if (result[0] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return checkContinue();
        }

        printResultMessage(result);

        return GameCode.CONTINUE.getCode();
    }

    private void printResultMessage(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
            return;
        }

        String message = "";

        message += makeResultMessage(result[0], " 스트라이크 ");
        message += makeResultMessage(result[1], "볼");
        System.out.println(message);
    }

    private String makeResultMessage(int result, String suffix) {
        if (result == 0) {
            return "";
        }
        return result + suffix;
    }

    private int checkContinue() {
        Scanner sc = new Scanner(System.in);
        int input;

        try {
            input = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return GameCode.EXIT.getCode();
        }

        return input == 1 ? GameCode.NEW_GAME.getCode() : GameCode.EXIT.getCode();
    }
}
