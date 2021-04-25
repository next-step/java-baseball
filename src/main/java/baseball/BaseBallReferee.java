package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseBallReferee {
    public static BaseBallGuessResult calculate(String goal, String guess) {
        BaseBallGuessResult guessResult = new BaseBallGuessResult();
        guessResult.setStrikeCount(countStrike(goal, guess));
        guessResult.setBallCount(countBall(goal, guess));
        guessResult.setIsFourBall(isFourBall(goal, guess));

        return guessResult;
    }

    private static int countStrike(String goal, String guess) {
        assert(goal.length() == guess.length());

        int strike = 0;
        for (int i = 0; i < goal.length(); i++) {
            strike += goal.charAt(i) == guess.charAt(i) ? 1 : 0;
        }
        return strike;
    }

    private static int countBall(String goal, String guess) {
        assert(goal.length() == guess.length());

        int ball = 0;
        for (int i = 0; i < goal.length(); i++) {
            ball += goal.contains(guess.substring(i, i + 1)) ? 1 : 0;
            ball -= goal.charAt(i) == guess.charAt(i) ? 1 : 0;
        }
        return ball;
    }

    private static boolean isFourBall(String goal, String guess) {
        assert(goal.length() == guess.length());

        Set<Character> set = new HashSet<>();
        for (int i=0; i < goal.length(); i++) {
            set.add(goal.charAt(i));
            set.add(guess.charAt(i));
        }
        return set.size() == goal.length() + guess.length();
    }
}
