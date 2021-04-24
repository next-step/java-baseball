package baseball.models;

import java.util.HashSet;

public class Calculator {

    public Integer[] calculateStrikesBallsOrNothing(String random, String input) {
        int strike = 0;
        int ball = 0;

        boolean[] alreadyStrike = new boolean[10];
        HashSet<Character> ballStore = new HashSet<>();

        strike = getStrikes(random, input, strike, alreadyStrike);
        ball = getBalls(random, input, ball, alreadyStrike, ballStore);

        return new Integer[]{strike,ball};
    }

    private int getBalls(String random, String input, int ball, boolean[] alreadyStrike, HashSet<Character> ballStore) {
        for(int i=0; i < random.length(); ++i) {
            ballStore.add(random.charAt(i));
        }

        for(int i=0; i< input.length(); ++i) {
            char cur = input.charAt(i);
            ball = plusBall(ball, alreadyStrike, ballStore, cur);
        }
        return ball;
    }

    private int plusBall(int ball, boolean[] alreadyStriked, HashSet<Character> ballStore, char cur) {
        if(ballStore.contains(cur) && !alreadyStriked[cur - '0']) ball++;
        return ball;
    }

    private int getStrikes(String random, String input, int strike, boolean[] alreadyStriked) {
        for(int i=0; i< input.length(); ++i) {
            strike = plusStrike(random, input, strike, alreadyStriked, i);
        }
        return strike;
    }

    private int plusStrike(String random, String input, int strike, boolean[] alreadyStriked, int i) {
        if(input.charAt(i) == random.charAt(i)) {
            alreadyStriked[input.charAt(i) - '0'] = true;
            strike++;
        }
        return strike;
    }
}

