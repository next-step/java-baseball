package me.rn00n.baseball.pitcher;

import me.rn00n.baseball.number.BaseballRandomNumber;

public class Pitcher {

    // 투수의 숫자
    private int number;

    // 숫자 자릿수 (기본 3)
    public int NUMBER_LENGTH = 3;

    public Pitcher() {
        this.number = BaseballRandomNumber.getNumber(NUMBER_LENGTH);
    }

    public Pitcher(int length) {
        this.NUMBER_LENGTH = length;
        this.number = BaseballRandomNumber.getNumber(NUMBER_LENGTH);
    }

    /**
     * 다음 자릿수가 있는지 확인
     * @param number
     * @return
     */
    private boolean hasNextNumber(int number) {
        String s_number = String.valueOf(number);
        return s_number.length() > 1; // 한자리수이면 false
    }

    /**
     * 스트라이크 개수 확인
     * @param predictNumber
     * @return
     */
    public int getStrike(int predictNumber) {
        int targetNumber = this.number;

        return countStrike(targetNumber, predictNumber);
    }
    /** 개수 반환 **/
    private int countStrike(int targetNumber, int predictNumber) {
        int count = 0;
        if (targetNumber % 10 == predictNumber % 10) {
            count++;
        }
        if (hasNextNumber(targetNumber)) { // 다음 자릿수가 있다면 진행
            count += countStrike(targetNumber / 10, predictNumber / 10);
        }
        return count;
    }

    /**
     * 볼 개수 확인 (문자열로 변환하여 처리)
     * @param predictNumber
     * @return
     */
    public int getBall(int predictNumber) {
        int targetNumber = this.number;
        String s_targetNumber = String.valueOf(targetNumber);
        String s_predictNumber = String.valueOf(predictNumber);
        int count = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            count += countBall(s_targetNumber, s_predictNumber, i);
        }
        return count;
    }
    /** 개수 반환 **/
    private int countBall(String s_targetNumber, String s_predictNumber, int i) {
        char target = s_targetNumber.charAt(i);

        if (target == s_predictNumber.charAt(i)) { // 스트라이크일 경우 카운트 x
            return 0;
        }
        if (s_predictNumber.contains(String.valueOf(target))) {
            return 1;
        }
        return 0;
    }

    /**
     * 포볼(낫싱) 확인
     * @param predictNumber
     * @return
     */
    public boolean isNothing(int predictNumber) {
        int count = 0;
        count += this.getStrike(predictNumber);
        count += this.getBall(predictNumber);

        if (count == 0) { // 스트라이크 + 볼 개수가 0이면 낫싱
            return true;
        }
        return false;
    }

    /* Getter, Setter (테스트 코드에서 사용) */
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
