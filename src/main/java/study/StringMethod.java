package study;

import java.util.Arrays;
import java.util.List;

public class StringMethod {

    public List<String> splitStringUsingComma(String inputString) {
        if (inputString.startsWith("(") && inputString.endsWith(")")) {
            inputString = inputString.substring(1, inputString.length() - 1);
        }

        return Arrays.asList(inputString.split(","));
    }

    public char getCharInString(String string, int index) {
        try {
            return string.charAt(index);
        } catch (StringIndexOutOfBoundsException e) {
            throw e;
        }
    }
}
