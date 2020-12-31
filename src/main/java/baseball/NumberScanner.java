package baseball;

import java.util.*;

public class NumberScanner {

    private final Scanner scan = new Scanner(System.in);

    public List<Integer> scan() {
        List<Integer> numberList;
        while (true) {
            String numberStr = scan.next();
            try {
                numberList = makeList(numberStr);
                break;
            } catch (RuntimeException e) {
                System.out.print("잘못된 입력입니다. 다시 입력해주세요: ");
            }
        }
        return numberList;
    }

    public List<Integer> makeList(String numberStr) {
        List<Integer> numberList = new ArrayList<>();
        for (char number : numberStr.toCharArray()) {
            numberList.add(charToInt(number));
        }

        Set<Integer> numberSet = Set.copyOf(numberList);
        if (numberSet.size() != 3) {
            throw new RuntimeException("입력값이 잘못되었습니다.");
        }
        return numberList;
    }

    public int charToInt(char input) {
        int number = Character.getNumericValue(input);
        if (number < 1 || number > 9) {
            throw new RuntimeException("입력값이 잘못되었습니다.");
        }
        return number;
    }
}
