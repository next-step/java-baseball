package domain.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {
    private final Set<Integer> answer;

    private NumberGenerator() {
        answer = new HashSet<>();
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
