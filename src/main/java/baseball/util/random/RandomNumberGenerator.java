package baseball.util.random;

public interface RandomNumberGenerator {
    int generateRandomNumber(int radix);

    static RandomNumberGenerator getDefault() {
        return radix -> (int)(Math.random() * (radix));
    }
}