package baseBall.util;

import java.util.ArrayList;
import java.util.List;

public class InputUserNumber {

    private final int MAX_LENGTH = 3;
    private final String NUMBER_PATTERN = "^[0-9]*$";

    private String userNumber = "";

    public InputUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public boolean checkValidation() {

        if(checkNumberLength() && checkDuplicateNumber() && checkNumberFormat()) {
            return true;
        }

        return false;
    }

    public boolean checkNumberLength() {
        if (userNumber.length() == MAX_LENGTH) {
            return true;
        }

        throw new IllegalArgumentException("입력 가능한 숫자 범위는 3자리 입니다.");


    }

    public boolean checkDuplicateNumber() {

        boolean isDuplicate = true;
        char[] convertedStringToCharArray = userNumber.toCharArray();

        List<Character> tempList = new ArrayList<Character>();

        for (char temp : convertedStringToCharArray) {

            if (tempList.contains(temp)) {
                isDuplicate = false;
                break;
            }

            tempList.add(temp);
        }

        if (!isDuplicate) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }

        return isDuplicate;

    }

    public boolean checkNumberFormat() {
        boolean isMatches = false;

        isMatches = userNumber.matches(NUMBER_PATTERN);

        if(!isMatches) {
            throw new IllegalArgumentException("숫자외 다른 문자열을 포함 할 수 없습니다.");
        }

        return isMatches;

    }

}
