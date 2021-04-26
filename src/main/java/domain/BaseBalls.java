package domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBalls {
    private static final int DIGIT = 3;
    private List<BaseBall> baseBalls = new ArrayList<>();

    public BaseBalls(String target) {
        int number;
        for(int index = 0; index < DIGIT; index += 1) {
            number = Integer.parseInt(String.valueOf(target.charAt(index)));
            this.baseBalls.add(BaseBall.fromNumAndLocation(number, index));
        }
    }

    public BaseBall get(int index) {
        return this.baseBalls.get(index);
    }

    public Integer strikeNumber(BaseBalls answer) {
        int score = 0;
        for(int i = 0; i < DIGIT; i++) {
            score += this.get(i)
                         .isEqualNumber(answer.get(i));
        }
        return score;
    }

    private int locationOf(BaseBall baseBall) {
        return this.baseBalls.indexOf(baseBall);
    }

    private int isBall(BaseBall baseball) {
        if(baseball.isSameLocation(locationOf(baseball))) {
            return 0;
        }
        return 1;
    }

    public Integer ballNumber(BaseBalls answer) {
        int score = 0;
        for(int i = 0; i < DIGIT; i++) {
            score += isBall(answer.get(i));
        }
        return score;

    }


}
