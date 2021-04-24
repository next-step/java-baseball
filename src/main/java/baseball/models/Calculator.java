package baseball.models;

import java.util.Arrays;
import java.util.HashSet;

public class Calculator {

    private int strike;
    private int ball;
    private final boolean[] alreadyStrike = new boolean[10];
    private final HashSet<Character> ballStore = new HashSet<>();

    public Integer[] calculateStrikesBallsOrNothing(String random, String input) {
        init();

        strike = getStrikes(random, input);
        ball = getBalls(random, input);

        return new Integer[]{strike, ball};
    }

    private void init() {
        strike = 0;
        ball = 0;
        Arrays.fill(alreadyStrike, false);
        ballStore.clear();
    }

    private int getBalls(String random, String input) {
        for (int i = 0; i < random.length(); ++i) {
            ballStore.add(random.charAt(i));
        }

        for (int i = 0; i < input.length(); ++i) {
            char cur = input.charAt(i);
            ball = plusBall(ball, cur);
        }
        return ball;
    }

    private int plusBall(int ball, char cur) {
        if (ballStore.contains(cur) && !alreadyStrike[cur - '0']) ball++;
        return ball;
    }

    private int getStrikes(String random, String input) {
        for (int idx = 0; idx < input.length(); ++idx) {
            strike = plusStrike(random, input, idx);
        }
        return strike;
    }

    private int plusStrike(String random, String input, int idx) {
        if (input.charAt(idx) == random.charAt(idx)) {
            alreadyStrike[input.charAt(idx) - '0'] = true;
            strike++;
        }
        return strike;
    }
}

