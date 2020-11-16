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
            checkBoll(userNumbers.get(i));
            checkStrike(i, userNumbers.get(i));
        }
        System.out.println(resultMessage());
    }

    public void checkBoll(String userNumber) {
        if (numbers.contains(userNumber)) {
            boll++;
        }
    }

    public void checkStrike(int index, String userNumber) {
        if (userNumber.equals(numbers.get(index))) {
            strike++;
            boll--;
        }
    }

    public String resultMessage() {
        if (strike == 0 && boll == 0) {
            return "낫싱";
        }
        return strikeMessage() + bollMessage();
    }

    public String strikeMessage() {
        if (strike > 0) {
            return strike + "스트라이크";
        }
        return "";
    }

    public String bollMessage() {
        if (strike > 0 && boll > 0) {
            return " " + boll + "볼";
        }
        if (boll > 0) {
            return boll + "볼";
        }
        return "";
    }


    public List<String> getNumbers() {
        return numbers;
    }

    public int getStrike() {
        return strike;
    }
}
