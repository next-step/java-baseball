package nextstep.precourse.baseball;

import java.util.Scanner;

public class BaseballUserInputNumberCompare {

    int strike = 0;
    int ball = 0;

    /**
     * @return 사용자에게 입력받은 3자리 수와 정답을 비교하여 strike가 3이면 리턴
     */
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

    /**
     * @return 사용자가 입력한 3자리 수를 리턴
     */
    private String userInputNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");

        return sc.nextLine();
    }

    /**
     * @param rightArray 정답 배열
     * @param inputNumberDivideArray 사용자에게 받은 3자리 수 문자열 배열
     */
    public void inputNumberCmpare(int[] rightArray, String[] inputNumberDivideArray) {
        for(int index = 0; index < rightArray.length; index++) {
            inputNumberCompareSub(rightArray, inputNumberDivideArray, index);
        }

        strikeAndBallPrint();
    }

    /**
     * @param rightArray 정답 배열
     * @param inputNumberDivideArray 사용자에게 받은 3자리 수 문자열 배열
     * @param index 정답 배열 index
     */
    public void inputNumberCompareSub(int[] rightArray, String[] inputNumberDivideArray, int index) {
        for(int secondIndex = 0; secondIndex < inputNumberDivideArray.length; secondIndex++) {
            strikeAndBallResult(rightArray, inputNumberDivideArray, index, secondIndex);
        }
    }

    /**
     * @param rightArray 정답 배열
     * @param inputNumberDivideArray 사용자에게 받은 3자리 수 문자열 배열
     * @param index 정답 배열 index
     * @param secondIndex 입력받은 문자열 배열 index
     */
    public void strikeAndBallResult(int[] rightArray, String[] inputNumberDivideArray, int index, int secondIndex) {
        if(rightValueAndInputValueCompare(rightArray[index], inputNumberDivideArray[secondIndex])) {
            strikeResult(index, secondIndex);
            ballResult(index, secondIndex);
        }
    }

    /**
     * @param rightValue 정답 배열 index
     * @param inputValue 입력받은 문자열 배열 index
     * @return 두 index 비교값
     */
    public boolean rightValueAndInputValueCompare(int rightValue, String inputValue) {
        return rightValue == Integer.parseInt(inputValue);
    }

    /**
     * @param index 정답 배열 index, 입력받은 문자열 배열 index
     * @param secondIndex 입력받은 문자열 배열 index
     * @return 두 index가 같으면 증가된 strike
     */
    public int strikeResult(int index, int secondIndex) {
        if(index == secondIndex) {
            return ++strike;
        }
        return strike;
    }

    /**
     * @param index 정답 배열 index
     * @param secondIndex 입력받은 문자열 배열 index
     * @return 두 index가 다르면 증가된 ball
     */
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
