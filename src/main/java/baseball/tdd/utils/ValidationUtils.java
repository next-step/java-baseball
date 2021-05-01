package baseball.tdd.utils;

public class ValidationUtils {

    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    public static boolean validNo(int no) {
        return no >= MIN_NO && no <= MAX_NO;
    }
}
