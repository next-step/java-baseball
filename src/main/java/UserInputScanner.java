import java.util.HashSet;
import java.util.Scanner;

public class UserInputScanner {
    static final int NUMBER_OF_DIGIT = 3;
    static final int MAX_NUMBER = 9;
    static final int MIN_NUMBER = 1;

    public String scanInput() {
        String input;
        do {
            System.out.printf("숫자를 입력해 주세요 : ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
        } while (!isValidateInput(input));
        return input;
    }

    private boolean isValidateInput(String input) {
        if (!isSizeOfRandomNumbersValidate(input))
            return false;
        if (!isEachNumberConsistNumber1To9(input))
            return false;
        return isEachNumberUnique(input);
    }

    private boolean isSizeOfRandomNumbersValidate(String input) {
        if (input.length() != NUMBER_OF_DIGIT) {
            System.out.println("3자리 숫자를 입력해야 합니다.");
            return false;
        }
        return true;
    }

    private boolean isEachNumberConsistNumber1To9(String input) {
        int invalidCount = 0;
        for (Character number : input.toCharArray()) {
            int valid = number >= '1' && number <= '9' ? 0 : 1;
            invalidCount += valid;
        }
        if (invalidCount != 0) {
            System.out.println("모든 숫자는 1~9 로만 구성되어야 합니다.");
            return false;
        }
        return true;
    }

    private boolean isEachNumberUnique(String input) {
        HashSet<Character> uniqueNumberCounter = new HashSet<>();
        for (Character number : input.toCharArray()) {
            uniqueNumberCounter.add(number);
        }
        if (uniqueNumberCounter.size() != NUMBER_OF_DIGIT) {
            System.out.println("각 자리수는 중복되지 않아야 합니다.");
            return false;
        }
        return true;
    }
}
