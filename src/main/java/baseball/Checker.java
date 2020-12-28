package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Checker {

    public int compare(int a, int b) {
        if (a == b) {
            return 1;
        }
        return 0;
    }

    public int checkStrike(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            strike += compare(computer.get(i), user.get(i));
        }
        return strike;
    }

    public int checkBall(List<Integer> computer, List<Integer> user) {
        Set<Integer> matchSet = new HashSet<>(computer);
        matchSet.retainAll(user);

        return matchSet.size() - checkStrike(computer, user);
    }
}
