import java.util.HashSet;
import java.util.Set;

public class BaseballGameNumberChecker {

    private int minNumber;
    private int lengthOfNumber;

    public BaseballGameNumberChecker(int lengthOfNumber) {
        this.lengthOfNumber = lengthOfNumber;
        this.minNumber = (int)Math.pow(10, lengthOfNumber - 1);
    }

    public boolean isCorrect(int num) {
        if (checkLength(num) || checkDup(num)) {
            return false;
        }
        return true;
    }

    public boolean checkLength(int num) {
        return num > minNumber;
    }

    public boolean checkDup(int num) {
        Set<Integer> check = new HashSet<>();
        for (int i = 0; i < lengthOfNumber; i++) {
            check.add(num % 10);
            num /= 10;
        }
        return check.size() == lengthOfNumber;
    }

}
