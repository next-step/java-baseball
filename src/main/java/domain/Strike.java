package domain;

import java.util.List;

public class Strike {
    public static int checkStrike(List<Integer> input, List<Integer> randomNumber) {
        int count = 0;
        for (int i = 0; i < randomNumber.size(); i++) {
            if (input.get(i).equals(randomNumber.get(i))) {
                count++;
            }
        }

        return count;
    }
}
