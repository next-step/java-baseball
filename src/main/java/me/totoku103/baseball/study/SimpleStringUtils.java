package me.totoku103.baseball.study;

public class SimpleStringUtils {
    public static String[] splitWithCommas(String target) {
        final String splitChar = ",";
        if (target == null || target.length() == 0) throw new NullPointerException("Null or Empty, check arguments");
        if (!target.contains(splitChar)) throw new RuntimeException(String.format("%s 문자를 포함하지 않습니다.", splitChar));

        return target.split(splitChar);
    }

    public static String removeStartAndLastParentheses(String target) {
        if (target.indexOf("(") == -1 || target.lastIndexOf(")") == -1) throw new IndexOutOfBoundsException("Not found parentheses");
        return target.substring(target.indexOf("(") + 1, target.lastIndexOf(")"));
    }

    public static char customCharAt(String string, int index) {
        return string.charAt(index);
    }
}
