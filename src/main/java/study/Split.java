package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {
    private String inputText;

    public Split(String inputText) {
        this.inputText = inputText;
    }

    public void checkValidText() {
        Matcher m = Pattern.compile("^[0-9]*,+").matcher(this.inputText);
        if (!m.find()) {
            throw new IllegalArgumentException("숫자와 ,(comma)가 아닌 문자가 있습니다.");
        }
    }

    public String[] splitByComma() {
        return inputText.split(",");
    }

}
