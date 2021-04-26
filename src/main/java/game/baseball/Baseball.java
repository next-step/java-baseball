package game.baseball;

import java.util.ArrayList;

public class Baseball {
    int[] computerNumbers;

    public Baseball() {
        computerNumbers = new int[BaseballConstants.BASEBALL_COUNT];

        makeComputerNumbers();
    }

    private void makeComputerNumbers() {
        ArrayList<Integer> numbersToBeSelected = generateSequentialNumbersBetween(1, 9);

        for (int i = 0; i < BaseballConstants.BASEBALL_COUNT; i++) {
            int selectIndex = (int) (Math.random() * numbersToBeSelected.size());
            computerNumbers[i] = numbersToBeSelected.get(selectIndex);
            numbersToBeSelected.remove(selectIndex);
        }
    }

    private ArrayList<Integer> generateSequentialNumbersBetween(int startIndex, int endIndex) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = startIndex; i <= endIndex; i++) {
            numbers.add(i);
        }

        return numbers;
    }
}
