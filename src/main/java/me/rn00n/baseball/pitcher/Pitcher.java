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

    /* Getter, Setter (테스트 코드에서 사용) */
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
