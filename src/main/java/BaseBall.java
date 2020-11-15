import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseBall {
    final int MAX_NUMBER = 3;
    Set<Integer> numberSet = new HashSet<>();
    int[] computerNumbers = new int[MAX_NUMBER];

    public int generateRandomNumber() {
        return new Random().nextInt(9) + 1;
    }

    public void insertDifferentNumbers(int number) {
        if(numberSet.add(number)){
            computerNumbers[numberSet.size() - 1] = number;
        }
    }
}
