package view;

import domain.BallCount;

public class OutputView {

    public void printResult(BallCount ballCount) {
        System.out.println(ballCount.toString());
    }

    public void printComplete() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printError() {
        System.out.println("입력값을 확인하세요!");
    }
}
