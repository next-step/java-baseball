package task;

import java.util.*;

public class Baseball {

    final Set<Integer> computer;
    Random random;
    final int COLLECTION_MAXIMUM_LENGTH = 3;
    final List<Integer> user;
    int strike = 0;
    int ball = 0;

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

    void compare() {
        Iterator<Integer> userIter = user.iterator();
        for(Integer number : computer) {
            strikeBallCheck(number, userIter.next());
        }
    }

    void strikeBallCheck(Integer computer, Integer user) {
        if(computer.equals(user)) {
            strike += 1;
            return;
        }
        if(this.user.contains(computer)) {
            ball += 1;
        }
    }

}
