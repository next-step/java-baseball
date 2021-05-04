package domain.core;

import java.util.*;

public class NumberGenerator {
    private final Set<Integer> answer;

    private NumberGenerator() {
        answer = new LinkedHashSet<>();
    }

    public static NumberGenerator newInstance(){
        return new NumberGenerator();
    }

    public List<Integer> getAnswer() {
        while (answer.size() != 3) {
            answer.add((int) (Math.random() * 10));
        }
        return new ArrayList<>(answer);
    }
}
