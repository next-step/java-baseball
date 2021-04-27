package application;

import game.GameRunner;

public class Application {
    public static void main(String[] args) {
        try {
            do {
            } while (GameRunner.checkRestart());
        } catch (Exception e) {
            System.out.println("게임이 실행 중 문제가 발생하였습니다. : " + e.getMessage());
        }
        System.out.println("모든 게임이 종료되었습니다.");
    }
}
