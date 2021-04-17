package baseball;

import java.util.*;

public class CheckInputNumValidation {

    public boolean isValid(String inputNum) {
        if(!isInteger(inputNum)){
            return false;
        }
        if(!isValidLength(inputNum)){
            return false;
        }
        if(!isNotDuplicate(inputNum)){
            return false;
        }
        return true;
    }

    private boolean isInteger(String inputNum) {
        for(int i = 0; i < inputNum.length(); i++) {
            if(!Character.isDigit(inputNum.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidLength(String inputNum) {
        return inputNum.length() == 3;
    }

    private boolean isNotDuplicate(String inputNum) {
        String[] numArray = inputNum.split("");
        Set<String> set = new HashSet<String>(Arrays.asList(numArray));
        return set.size() == 3;
    }
}
