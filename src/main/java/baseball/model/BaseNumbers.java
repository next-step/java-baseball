package baseball.model;

import java.util.Arrays;
import java.util.List;

import baseball.etc.Utils;

public class BaseNumbers {
    private final List<String> numbers;

    public BaseNumbers(String[] numbers) {
        this.numbers = Arrays.asList(numbers);
    }

    /**
     * 야구 게임에 사용할 숫자 배열 리턴.
     * @return 야구 게임에 사용할 숫자 배열.
     */
    public List<String> getNumbers() {
        return this.numbers;
    }

    /**
     * 사용자가 입력한 숫자들과 가지고 있는 숫자들과 비교.
     * @param input 사용자가 입력한 값.
     * @return 야구 게임 결과 값.
     */
    public BaseballResult checkNumbers(String input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < input.length(); i++) {
            String digit = Character.toString(input.charAt(i));
            strike += Utils.booleanToInt(this.isStrike(digit, i));
            ball += Utils.booleanToInt(this.isBall(digit));
        }
        // 볼의 경우 스트라이크 수와 겹치기 때문에 스트라이크 수 만큼 빼준다.
        ball = ball - strike;

        return new BaseballResult(strike, ball, this.getNumbers().size());
    }

    /**
     * 스트라이크 여부 확인.
     * @param inputData 사용자가 입력한 숫자 1자리.
     * @param inputIndex 사용자가 입력한 숫자의 위치.
     * @return 스트라이크 여부.
     */
    public boolean isStrike(String inputData, int inputIndex) {
        // index값이 0이하 거나 가지고 있는 수 초과시.
        if (inputIndex > (this.numbers.size() - 1) || inputIndex < 0) {
            return false;
        }

        return this.numbers.get(inputIndex).equals(inputData);
    }

    /**
     * 볼 여부 확인.
     * @param inputData 사용자가 입력한 숫자 1자리.
     * @return 볼 여부.
     */
    public boolean isBall(String inputData) {
        return this.numbers.contains(inputData);
    }
}
