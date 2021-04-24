package com.woowahan.precourse.baseball.domain;

public class BaseBallGame {

    private String[] gameNumber;  // 컴퓨터가 선택한 세자리 수 - Game 생성 시 같이 생성되어야 함.

    public BaseBallGame() {
        this.gameNumber = createBallGameNumber();
    }

    private String generateRandomNumber() {
        return String.valueOf((int) (Math.random() * 9 + 1));
    }

    private String[] createBallGameNumber() {

        String firstNumber = generateRandomNumber();
        String secondNumber = "";
        String thirdNumber = "";

        do {
            secondNumber = generateRandomNumber();
        } while (firstNumber.equals(secondNumber));

        do {
            thirdNumber = generateRandomNumber();
        } while (secondNumber.equals(thirdNumber) || firstNumber.equals(thirdNumber));

        return new String[] { firstNumber, secondNumber, thirdNumber };
    }

}
