package domain;

import java.util.List;

public class Ball {
    public static int checkBall(List<Integer> input, List<Integer> randomNumber) {
        int count = 0;

        for (int i = 0; i < randomNumber.size(); i++) {
            count = calculateCount(input, randomNumber, count, i);
        }

        return count;
    }

    private static int calculateCount(List<Integer> input, List<Integer> randomNumber, int count, int i) {
        if (input.contains(randomNumber.get(i)) && !input.get(i).equals(randomNumber.get(i))) {
            count++;
        }
        return count;
    }
}
