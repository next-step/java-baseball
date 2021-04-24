package baseball;

public class RandomNumGenerator {

    private static boolean isDone;

    String getThreeNumbers() {
        isDone = false;
        boolean[] duplicatedNumCheck = new boolean[10];
        StringBuilder random = new StringBuilder();

        do {
            int choice = (int) (Math.random() * 9) + 1;
            getIfNotDuplicated(duplicatedNumCheck, random, choice);

        } while(!checkIfDone(random));

        return random.toString();
    }

    private void getIfNotDuplicated(boolean[] duplicatedNumCheck, StringBuilder random, int choice) {
        if (!duplicatedNumCheck[choice]) {
            duplicatedNumCheck[choice] = true;
            random.append(choice);
        }
    }
    private boolean checkIfDone(StringBuilder random) {
        if(random.length() == 3) isDone = true;
        return isDone;
    }
}
