package baseballgame;

import java.util.ArrayList;
import java.util.List;

public class InputNumberValidator {
    List<String> errors = new ArrayList<>();

    public List<String> validate(String input) {
        int digit = input.length();
        if(digit > 3) errors.add("세 자릿수보다 많습니다. 세 자릿수를 입력해 주세요.");
        if(digit < 3) errors.add("세 자릿수보다 적습니다. 세 자릿수를 입력해 주세요.");
        if(digit == 3 && hasSameNumber(input)) errors.add("서로 다른 세자리 수를 입력해 주세요.");
        if(input.contains("0")) errors.add("0을 입력 할 수 없습니다.");
        if(input.matches(".*[a-zA-Z]+.*")) errors.add("숫자만 입력 가능합니다.");
        return errors;
    }

    private boolean hasSameNumber(String input) {
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);

        if(first == second || second == third || first == third) {
            return true;
        }
        return false;
    }
}
