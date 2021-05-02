package start.game;

public class ValidationUtils {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    
    public static boolean isInOneToNightNumber(int number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }
}
