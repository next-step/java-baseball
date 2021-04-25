package basball.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberFactory {

    private final List<Integer> baseNumber = Arrays.asList(1,2,3,4,5,6,7,8,9);

    public List<Integer> createRandomNumber() {
        Collections.shuffle(baseNumber);
        return baseNumber.subList(0,3);
    }

    public List<Integer> createUserNumber(String number) {
        List<Integer> userNumber = new ArrayList<>();
        for (int i = 0 ; i < number.length() ; i ++) {
            userNumber.add(toIntegerList(number.charAt(i)));
        }
        return userNumber;
    }

    private int toIntegerList(char number) {
        return number-'0';
    }
}
