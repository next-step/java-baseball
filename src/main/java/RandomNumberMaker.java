import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberMaker {
    public static final int lengthOfNumber = 3;
    public String getRandomNumber() {
        String randomNumber = "";
        List<Integer> possibleNumbers = getPossibleNumbers();
        for (int i = 0; i < lengthOfNumber; i++) {
            int number = possibleNumbers.remove(Math.abs(new Random().nextInt()) % possibleNumbers.size());
            randomNumber += ("" + number);
        }
        return randomNumber;
    }

    List<Integer> getPossibleNumbers(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
