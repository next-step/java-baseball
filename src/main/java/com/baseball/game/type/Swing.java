package com.baseball.game.type;

import com.baseball.game.domain.Batter;
import com.baseball.game.domain.Pitcher;
import com.baseball.game.service.SwingOperator;

import java.util.Arrays;

public enum Swing implements SwingOperator {
    NOTHING(""){
        public boolean isSwing(Pitcher pitcher, Batter batter, int idx){
            return !pitcher.isPresent(batter.getNumberFromIndex(idx));
        }
    },
    BALL("볼"){
        public boolean isSwing(Pitcher pitcher, Batter batter, int idx){
            return pitcher.isPresent(batter.getNumberFromIndex(idx)) && !isEqualsValueAndIndex(pitcher, batter, idx);
        }
    },
    STRIKE("스트라이크"){
        public boolean isSwing(Pitcher pitcher, Batter batter, int idx){
            return isEqualsValueAndIndex(pitcher, batter, idx);
        }
    };

    private String text;

    Swing(String text) {
        this.text = text;
    }

    public static Swing findSwingResult(Pitcher pitcher, Batter batter, int idx) {
        return Arrays.stream(Swing.values())
                .filter(s -> s.isSwing(pitcher, batter, idx))
                .findFirst()
                .get();
    }

    public boolean isEqualsValueAndIndex(Pitcher pitcher, Batter batter, int idx) {
        return pitcher.getNumberBox().get(idx).equalsNumber(batter.getNumberBox().get(idx).getNumber());
    }

    public String getText(){
        return this.text;
    }
}