package com.baseball.precourse.baseball;

import com.baseball.precourse.util.DigitString;

public class Ball {
    public static final int BALL_COUNT = 3;
    private DigitString value;

    public Ball(String input){
        if(input.length() != BALL_COUNT){
            throw new IllegalArgumentException(String.format("숫자 길이가 %d 이어야 합니다(입력: %d)", BALL_COUNT, input.length()));
        }
        this.value = new DigitString(input);
    }

    public DigitString getValue(){
        return this.value;
    }


    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Ball other = (Ball) obj;
        if (other.getValue().equals(value)){
            return true;
        }
        return false;
    }
}
