package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baseball {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int NUMBER_SELECTED_SIZE = 3;
    private static final String REG_EXP =
            "^[" + MINIMUM_NUMBER + "-" + MAXIMUM_NUMBER + "]{" + NUMBER_SELECTED_SIZE + "}$";

    public Baseball() {}

    public void start() {
        int[] computerNumbers = prepareComputerNumbers();
        int[] userNumbers = prepareUserNumbers();
    }

    public int[] prepareComputerNumbers() {
        List<Integer> orderedNumbers = createOrderedNumbers();
        int[] computerNumbers = new int[NUMBER_SELECTED_SIZE];
        for (int i = 0; i < NUMBER_SELECTED_SIZE; i++) {
            int index = generateIndex(i);
            computerNumbers[i] = orderedNumbers.get(index);
            orderedNumbers.remove(index);
        }
        return computerNumbers;
    }

    private List<Integer> createOrderedNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MINIMUM_NUMBER; i < MAXIMUM_NUMBER + 1; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private int generateIndex(int i) {
        return (int)(Math.random() * 10000) % (MAXIMUM_NUMBER - i);
    }

    public int[] prepareUserNumbers() {
        Scanner scan = new Scanner(System.in);
        boolean loof = true;
        String inputNumber = null;
        while (loof) {
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = scan.next();
            loof = !checkInputNumbers(inputNumber);
        }
        return convertStringToIntArray(inputNumber);
    }

    public boolean checkInputNumbers(String inputNumber)  {
        if (inputNumber.matches(REG_EXP)) {
            return true;
        }
        return false;
    }

    public int[] convertStringToIntArray(String inputNumber) {
        char[] inputNumbers = inputNumber.toCharArray();
        int[] userNumbers = new int[NUMBER_SELECTED_SIZE];
        for (int i = 0; i < inputNumber.length(); i++) {
            userNumbers[i] = Integer.parseInt(String.valueOf(inputNumbers[i]));
        }
        return userNumbers;
    }

}
