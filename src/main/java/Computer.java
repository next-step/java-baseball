import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Computer {

    private List<String> numbers;
    private Random random;
    private int strike;
    private int boll;

    public Computer() {
        random = new Random(System.currentTimeMillis());
    }

    public void generateNumber() {
        numbers = new ArrayList<>();
        List<String> numberList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(numberList.size());
            numbers.add(numberList.remove(randomIndex));
        }
    }

    public void checkResult(List<String> userNumbers) {
        strike = 0;
        boll = 0;
        for (int i = 0; i < 3; i++) {
            checkStrikeAndBoll(i, userNumbers.get(i));
        }
        resultMessage();
    }

    public void checkStrikeAndBoll(int index, String userNumber) {
        if (numbers.contains(userNumber)) {
            boll++;
        }
        if (userNumber.equals(numbers.get(index))) {
            strike++;
            boll--;
        }
    }

    public void resultMessage() {
        String message = "";
        if (strike > 0) {
            message += strike + " 스트라이크 ";
        }
        if (boll > 0) {
            message += boll + "볼";
        }
        if (strike == 0 && boll == 0) {
            message = "낫싱";
        }
        System.out.println(message);
    }

    public List<String> getNumbers() {
        return numbers;
    }

}
