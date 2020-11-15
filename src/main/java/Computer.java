import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Computer {

    private List<Integer> numbers;
    private Random random;

    public Computer() {
        random = new Random(System.currentTimeMillis());
    }

    public void generateNumber() {
        numbers = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(numberList.size());
            numbers.add(numberList.get(randomIndex));
            numberList.remove(randomIndex);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
