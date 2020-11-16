package com.baseball.game.type;

import com.baseball.game.service.NumberBox;
import com.baseball.game.service.SwingOperator;

import java.util.Arrays;

public enum Swing implements SwingOperator {
    NOTHING("NOTHING!"){
        public boolean isSwing(NumberBox pitcherBox, NumberBox batterBox, int idx){
            return !isContains(pitcherBox, batterBox, idx);
        }
    },
    BALL("BALL!"){
        public boolean isSwing(NumberBox pitcherBox, NumberBox batterBox, int idx){
            return isContains(pitcherBox, batterBox, idx) && !isEqualsValueAndIndex(pitcherBox, batterBox, idx);
        }
    },
    STRIKE("STRIKE!"){
        public boolean isSwing(NumberBox pitcherBox, NumberBox batterBox, int idx){
            return isEqualsValueAndIndex(pitcherBox, batterBox, idx);
        }
    };

    private String text;

    Swing(String text) {
        this.text = text;
    }

    private static boolean isEqualsValueAndIndex(NumberBox pitcherBox, NumberBox batterBox, int idx) {
        return pitcherBox.getNumberBox().get(idx).equals(batterBox.getNumberBox().get(idx));
    }
    private static boolean isContains(NumberBox pitcherBox, NumberBox batterBox, int idx) {
        return pitcherBox.getNumberBox().contains(batterBox.getNumberBox().get(idx));
    }

    public static Swing swingResult(NumberBox pitcherBox, NumberBox batterBox, int idx) {
        return Arrays.stream(Swing.values())
                .filter(s -> s.isSwing(pitcherBox, batterBox, idx))
                .findFirst()
                .get();
    }

    public String getText(){
        return this.text;
    }
}