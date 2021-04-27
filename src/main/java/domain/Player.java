package domain;

import java.util.Scanner;

public class Player {

    Ball ball;

    public void inputBall() {
        System.out.print("숫자를 입력하세요 : ");
        ball = new Ball(inputNumber());
    }

    public String getFinishNumber() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");

        return inputNumber();
    }

    private String inputNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
