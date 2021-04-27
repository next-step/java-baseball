package domain;

import java.util.*;

public class UserInputBaseballNumber {
    public static List<Integer> userBaseballNumber(String numbers) {
        List<Integer> userBaseballNumbers = new ArrayList<>();
        for(int i =0; i < numbers.length(); i++) {
            int input = (Character.getNumericValue(numbers.charAt(i)));
            userBaseballNumbers.add(input);
        }
        new Validation(userBaseballNumbers);
        return userBaseballNumbers;
    }
}