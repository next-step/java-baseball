package com.netxstep.baseball.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Result {

    private int strike;
    private int ball;

    public void incrementStrike() {
        this.strike++;
    }

    public void incrementBall() {
        this.ball++;
    }
}
