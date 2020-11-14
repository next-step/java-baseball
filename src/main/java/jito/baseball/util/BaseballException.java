package jito.baseball.util;

public class BaseballException {

    public static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
}
