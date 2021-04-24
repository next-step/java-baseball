package baseBall.util;

import java.util.ArrayList;
import java.util.List;

public class InputUserNumber {

    private final int MAX_LENGTH = 3;
    private final String NUMBER_PATTERN = "^[0-9]*$";

    public boolean checkNumberLength(String userNumber) {
        boolean isLength = false;
        if (userNumber.length() == MAX_LENGTH) {
            isLength = true;
        }

        return isLength;

    }

    public boolean checkDuplicateNumber(String userNumber) {

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

        return isDuplicate;

    }

    public boolean checkNumberFormat(String userNumber) {

        return userNumber.matches(NUMBER_PATTERN);



    }

}
