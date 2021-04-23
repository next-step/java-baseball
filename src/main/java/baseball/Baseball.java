package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {

    /***
     * 베이스볼 게임의 정답을 랜덤 생성한다.
     * 이 때, 정답은 111~ 999 사이의 중복되는 수가 없는 3자리 수 이다.
     */
    public String makeBaseballNumberString() {
        int firstDigit = makeRandomIntRangeOneToNine();
        int secondDigit = makeRandomIntRangeOneToNine();
        int thirdDigit = makeRandomIntRangeOneToNine();

        if (isValidBaseballNumberDigit(firstDigit, secondDigit, thirdDigit)) {
            return "" + firstDigit + secondDigit + thirdDigit;
        }

        return makeBaseballNumberString();
    }

    private int makeRandomIntRangeOneToNine() {
        Random random = new Random();
        return random.nextInt(8) + 1;
    }

    private boolean isValidBaseballNumberDigit(int firstDigit, int secondDigit, int thirdDigit) {
        return (firstDigit != secondDigit && firstDigit != thirdDigit && secondDigit != thirdDigit);
    }

    /**
     * 입력으로 받은 정답 예측수가 베이스볼 게임에 유효한 숫자인지 여부를 판단한다.
     */
    public boolean isValidBaseballInputNumber(int input) {
        String inputString = Integer.toString(input);
        return isInValidRange(input)
                && isInValidRangeDigit(inputString)
                && isValidNumberDigit(inputString);
    }

    private boolean isInValidRange(int input) {
        return input >= 111 && input <= 999;
    }

    private boolean isValidNumberDigit(String predictionNumberString) {
        return predictionNumberString.charAt(0) != predictionNumberString.charAt(1)
                && predictionNumberString.charAt(0) != predictionNumberString.charAt(2)
                && predictionNumberString.charAt(1) != predictionNumberString.charAt(2);
    }

    private boolean isInValidRangeDigit(String predictionNumberString) {
        List<Boolean> checkResult = new ArrayList<>();
        for (int i = 0; i < predictionNumberString.length(); ++i) {
            checkResult.add(isInOneToNine(predictionNumberString.charAt(i)));
        }
        return !checkResult.contains(false);
    }

    private boolean isInOneToNine(char ascii) {
        int number = ascii - 48;
        return number >= 1 && number <= 9;
    }
}
