package task;

import java.util.*;

public class Baseball {

    final Set<Integer> computer;
    Random random;
    final int COLLECTION_MAXIMUM_LENGTH = 3;
    final List<Integer> user;

    Scanner scanner;

    public Baseball() {
        computer = new HashSet<>();
        random = new Random();
        user = new ArrayList<>();
    }

    void computerNumberInput() {
        while(computer.size() < COLLECTION_MAXIMUM_LENGTH)
            computer.add(random.nextInt(10)+1);
    }

    void userGameNumberInput() {
        while(user.size() < COLLECTION_MAXIMUM_LENGTH)
            user.add(scannerIntInput());
    }

    int scannerIntInput() {
        return scanner.nextInt();
    }

}
