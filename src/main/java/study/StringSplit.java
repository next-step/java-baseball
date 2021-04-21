package study;

import java.util.Arrays;
import java.util.List;

public class StringSplit {

    public List<String> splitStringUsingComma(String inputString) {
        if (inputString.startsWith("(") && inputString.endsWith(")"))
            inputString = inputString.substring(1, inputString.length()-1);

        return Arrays.asList(inputString.split(","));
    }

}
