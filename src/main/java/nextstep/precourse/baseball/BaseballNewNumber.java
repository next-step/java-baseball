package nextstep.precourse.baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseballNewNumber {

    public Set<Integer> newRandomNumber() {
        Set<Integer> newRightNumber = new HashSet<>();

        while(newRightNumber.size() < 3) {
            newRightNumber.add((int) (Math.random() * 9 + 1));
        }

        return newRightNumber;
    }

}
