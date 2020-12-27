package baseball;

import java.util.List;

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
}
