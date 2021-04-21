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
            this.baseBalls.add(BaseBall.fromNumber(number));
        }
    }

    public String scoreOfBall(BaseBalls answer) {
        for(int i = 0; i < DIGIT; i++) {

        }
        return "";
    }
}
