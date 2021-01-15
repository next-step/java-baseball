import java.util.HashMap;

public class BaseballUser {
    private HashMap<Integer, Integer> numbers;

    public void userThreeIntegerInput() {
        int input = 0;

        while (true) {
            numbers = new HashMap<>();
            System.out.print("숫자를 입력해주세요 : ");
            input = GameManager.userInput.nextInt();

            if(numberSeparator(input)){
                break;
            }
            System.out.println("잘못된 값을 입력했습니다. 다시 입력해주세요 !");
        }
    }

    private Boolean numberSeparator(int number) {
        if (!isThreeNumber(number)) {
            return Boolean.FALSE;
        }

        for (int i = 0, divider= 100; i < 3; ++i, divider /= 10){
            int quotient = number / divider;
            number = number % divider;
            numbers.put(quotient, i);

            if (!isOneToNine(quotient) || isDuplicated(i)) {
                return Boolean.FALSE;
            }
        }

        if (numbers.size() != 3) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private Boolean isThreeNumber(int number) {
        int numberLength = Integer.toString(number).length();
        if (numberLength == 3) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Boolean isOneToNine(int number) {
        if (10 > number && number > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Boolean isDuplicated(int order) {
        if (numbers.size() == order){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public HashMap<Integer, Integer> getNumbers() {
        return numbers;
    }
}