package com.baseball.game.type;

import com.baseball.game.domain.Batter;
import com.baseball.game.domain.Pitcher;
import com.baseball.game.service.SwingOperator;

import java.util.Arrays;

public enum Swing implements SwingOperator {
    NOTHING("NOTHING!"){
        public boolean isSwing(Pitcher pitcher, Batter batter, int idx){
            return !pitcher.isPresent(batter.getNumberFromIndex(idx));
        }
    },
    BALL("BALL!"){
        public boolean isSwing(Pitcher pitcher, Batter batter, int idx){
            return pitcher.isPresent(batter.getNumberFromIndex(idx)) && !isEqualsValueAndIndex(pitcher, batter, idx);
        }
    },
    STRIKE("STRIKE!"){
        public boolean isSwing(Pitcher pitcher, Batter batter, int idx){
            return isEqualsValueAndIndex(pitcher, batter, idx);
        }
    };

    private String text;

    Swing(String text) {
        this.text = text;
    }

    public static Swing swingResult(Pitcher pitcher, Batter batter, int idx) {
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