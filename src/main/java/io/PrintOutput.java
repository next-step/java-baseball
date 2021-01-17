package io;

public class PrintOutput {
    /**
     * Print out result of nothing.
     */
    public void printNothing() {
        System.out.println("낫싱");
    }

    /**
     * Print out result of strike.
     * @param strike Integer of strike count
     */
    public void printStrike(int strike) {
        System.out.printf("%d스트라이크%n", strike);
    }

    /**
     * Print out result of ball.
     * @param ball Integer of ball count
     */
    public void printBall(int ball) {
        System.out.printf("%d볼%n", ball);
    }

    /**
     * Print out result of strike and ball.
     * @param strike Integer of strike count
     * @param ball Integer of ball count
     */
    public void printStrikeAndBall(int strike, int ball) {
        System.out.printf("%d볼 %d스트라이크%n", ball, strike);
    }

    /**
     * Print out result of complete.
     */
    public void printComplete() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * Print out error message.
     */
    public void printError() {
        System.out.println("입력값을 확인하세요!");
    }
}
