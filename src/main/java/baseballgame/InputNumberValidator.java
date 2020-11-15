package baseballgame;

import java.util.*;

public class InputNumberValidator {
    private final int NUMBER_LENGTH = 3;
    List<String> errors = new ArrayList<>();

    public List<String> validate(String input) {
        int digit = input.length();
        if(digit > NUMBER_LENGTH) errors.add("세 자릿수보다 많습니다. 세 자릿수를 입력해 주세요");
        if(digit < NUMBER_LENGTH) errors.add("세 자릿수보다 적습니다. 세 자릿수를 입력해 주세요");
        if(digit == NUMBER_LENGTH && hasSameNumber(input)) errors.add("서로 다른 세자리 수를 입력해 주세요");
        if(input.contains("0")) errors.add("0을 입력 할 수 없습니다");
        if(input.matches(".*[a-zA-Z]+.*")) errors.add("숫자만 입력 가능합니다");
        return errors;
    }

    private boolean hasSameNumber(String input) {
        String[] split = input.split("");
        Set<String> inputSet = new HashSet<>(Arrays.asList(split));
        return inputSet.size() < NUMBER_LENGTH;
    }
}
