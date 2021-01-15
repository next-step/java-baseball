package io;

public class PrintOutput {

    public void printNothing() {
        System.out.println("낫싱");
    }

    public void printStrike(int strike) {
        System.out.printf("%d스트라이크%n", strike);
    }

    public void printBall(int ball) {
        System.out.printf("%d볼%n", ball);
    }

    public void printStrikeAndBall(int strike, int ball) {
        System.out.printf("%d볼 %d스트라이크%n", ball, strike);
    }

    public void printComplete() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printError() {
        System.out.println("입력값을 확인하세요!");
    }
}
