package game;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int NUMBER_SELECTED_SIZE = 3;

    public Baseball() {}

    public void start() {
        int[] computerNumbers = prepareComputerNumbers();
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

}
