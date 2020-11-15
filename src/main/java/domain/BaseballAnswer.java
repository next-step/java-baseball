package domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseballAnswer {
    private Integer[] answer;

    public Integer[] getAnswer() {
        return answer;
    }

    public void makeAnswer() {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        while (numbers.size() != 3) {
            numbers.add(random.nextInt(8) + 1);
        }
        answer = new Integer[numbers.size()];
        numbers.toArray(answer);
    }
}
