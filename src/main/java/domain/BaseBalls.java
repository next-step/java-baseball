package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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

    private boolean isContaining(BaseBall opponent) {
        AtomicBoolean value = new AtomicBoolean(false);
        baseBalls.forEach((baseBall) -> {
            if(baseBall.isEqualNumber(opponent) == 1) {
                value.set(!baseBall.isSameLocation(opponent));
            }
        });

       return value.get();
    }

    private int isBall(BaseBall baseball) {
        if(!isContaining(baseball)) {
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
