package nextstep.precourse.baseball;

import java.util.Scanner;

public class BaseballUserInputNumberCompare {

    int strike = 0;
    int ball = 0;

    public int rightArrayAndUserInputCompare(int[] rightArray) {
        strike = 0;

        while(strike != 3) {
            strike = 0;
            ball = 0;

            String[] inputNumberDivideArray = userInputNumber().split("");
            inputNumberCmpare(rightArray, inputNumberDivideArray);
        }
        return strike;
    }

    private String userInputNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");

        return sc.nextLine();
    }

    public void inputNumberCmpare(int[] rightArray, String[] inputNumberDivideArray) {
        for(int index = 0; index < rightArray.length; index++) {
            inputNumberCompareSub(rightArray, inputNumberDivideArray, index);
        }

        strikeAndBallPrint();
    }

    public void inputNumberCompareSub(int[] rightArray, String[] inputNumberDivideArray, int index) {
        for(int secondIndex = 0; secondIndex < inputNumberDivideArray.length; secondIndex++) {
            strikeAndBallResult(rightArray, inputNumberDivideArray, index, secondIndex);
        }
    }

    public void strikeAndBallResult(int[] rightArray, String[] inputNumberDivideArray, int index, int secondIndex) {
        if(rightValueAndInputValueCompare(rightArray[index], inputNumberDivideArray[secondIndex])) {
            strikeResult(index, secondIndex);
            ballResult(index, secondIndex);
        }
    }

    public boolean rightValueAndInputValueCompare(int rightValue, String inputValue) {
        return rightValue == Integer.parseInt(inputValue);
    }

    public int strikeResult(int index, int secondIndex) {
        if(index == secondIndex) {
            return ++strike;
        }
        return strike;
    }

    public int ballResult(int index, int secondIndex) {
        if(index != secondIndex) {
            return ++ball;
        }
        return ball;
    }

    public void strikeAndBallPrint() {
        if(strike > 0) {
            System.out.print(strike + "스트라이크");
        }

        if(ball > 0) {
            System.out.print(ball + "볼");
        }
        System.out.println();
    }
}
