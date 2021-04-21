import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersGenerator {

    private final RandomGenerator randomGenerator;

    public NumbersGenerator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public List<Integer> makeNumbers() {

        Set<Integer> set = new HashSet<>();

        while(set.size() < 3) {
            set.add(randomGenerator.nextInt());
        }

        return Collections.unmodifiableList(new ArrayList<>(set));
    }
}
