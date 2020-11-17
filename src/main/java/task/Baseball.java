package task;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Baseball {

    final Set<Integer> computer;
    Random random;
    final int COLLECTION_MAXIMUM_LENGTH = 3;

    public Baseball() {
        computer = new HashSet<>();
        random = new Random();
    }

    void computerNumberInput() {
        while(computer.size() < COLLECTION_MAXIMUM_LENGTH)
            computer.add(random.nextInt(10)+1);
    }
}
