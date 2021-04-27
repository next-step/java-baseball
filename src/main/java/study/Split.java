package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {
    private String inputText;
    private static final int FIRST_SUBSTRING_INDEX = 1;
    private static int LAST_SUBSTRING_INDEX;

    public Split(String inputText) {
        checkOneMoreLength(inputText);
        this.inputText = inputText;
        LAST_SUBSTRING_INDEX = inputText.length() - 1;
    }

    private void checkOneMoreLength(String inputText) {
        if (inputText.length() <= 0) {
            throw new IllegalArgumentException("입력한 문자는 1글자 이상이어야합니다.");
        }
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

    public String removeParenthesis() {
        return this.inputText.replaceAll("\\(*\\)*", "");
    }

    public String removeParenthesis2() {
        return this.inputText.substring(FIRST_SUBSTRING_INDEX, LAST_SUBSTRING_INDEX);
    }

}
