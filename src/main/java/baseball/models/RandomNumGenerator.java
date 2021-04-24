package baseball.models;

import java.util.Arrays;

public class RandomNumGenerator {

    private static boolean isDone;
    private final boolean[] duplicatedNumCheck = new boolean[10];
    private StringBuilder random;

    String getThreeNumbers() {
        init();

        do {
            int choice = (int) (Math.random() * 9) + 1;
            getIfNotDuplicated(choice);

        } while (!checkIfDone(random));

        return random.toString();
    }

    private void init() {
        isDone = false;
        Arrays.fill(duplicatedNumCheck, false);
        random = new StringBuilder();
    }

    private void getIfNotDuplicated(int choice) {
        if (!duplicatedNumCheck[choice]) {
            duplicatedNumCheck[choice] = true;
            random.append(choice);
        }
    }

    private boolean checkIfDone(StringBuilder random) {
        if (random.length() == 3) isDone = true;
        return isDone;
    }
}
