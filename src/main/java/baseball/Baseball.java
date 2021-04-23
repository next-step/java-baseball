package baseball;

import java.util.Random;

public class Baseball {

    /***
     * 베이스볼 게임의 정답을 랜덤 생성한다.
     * 이 때, 정답은 111~ 999 사이의 중복되는 수가 없는 3자리 수 이다.
     * @return 베이스볼 게임의 정답(랜덤)
     */
    public String makeBaseballNumberString() {
        int firstDigit = makeRandomIntRangeOneToNine();
        int secondDigit = makeRandomIntRangeOneToNine();
        int thirdDigit = makeRandomIntRangeOneToNine();

        if (isValidBaseballNumber(firstDigit, secondDigit, thirdDigit)) {
            return "" + firstDigit + secondDigit + thirdDigit;
        }

        return makeBaseballNumberString();
    }

    private int makeRandomIntRangeOneToNine() {
        Random random = new Random();
        return random.nextInt(8) + 1;
    }

    private boolean isValidBaseballNumber(int firstDigit, int secondDigit, int thirdDigit) {
        if (firstDigit == secondDigit
                || firstDigit == thirdDigit
                || secondDigit == thirdDigit) {
            return false;
        }

        return true;
    }

}
