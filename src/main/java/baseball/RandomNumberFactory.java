package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberFactory {

    private final Random random;
    private final Set<Integer> store;

    public RandomNumberFactory(){
        random = new Random();
        store = new HashSet<>();
    }

    public String make() {
        makeNumberWithoutDuplicate();

        StringBuilder sb = new StringBuilder();
        store.iterator().forEachRemaining(a -> sb.append(a));
        return sb.toString();
    }

    private void makeNumberWithoutDuplicate(){
        store.clear();
        while(store.size() < BallCount.BALL_COUNT_SIZE){
            int number = make1to9();
            store.add(number);
        }
    }

    private int make1to9(){
        return random.nextInt(8) + 1;
    }
}
