package kr.insup.view;

import kr.insup.domain.GameOptions;

import java.util.Scanner;

public class GameView {
    private static Scanner scanner = new Scanner(System.in);

    public static void printStartMessage() {
        System.out.println("게임을 시작합니다");
    }

    public static void printNumberGenerated() {
        System.out.println("숫자를 맞춰보세요");
    }

    public static String requestInputNumber() {
        System.out.println(GameOptions.HOW_MANY_DIGIT + "자리 숫자를 입력해주세요");

        return scanner.next();
    }

    public static void printWrongInputNumber() {
        System.out.println("잘못된 숫자를 입력했습니다");
    }

    public static void printStrikeBall(int strike, int ball) {
        System.out.println(strike + " 스트라이크, " + ball + " 볼");
    }

    public static void printFourBall() {
        System.out.println("포볼 입니다");
    }

    public static String printGameOverAndAskRestart() {
        System.out.println("맞췄습니다!");
        System.out.println("게임을 종료하려면 1번");
        System.out.println("게임을 다시 시작하려면 아무키나 누르세요");

        return scanner.next();
    }
}
