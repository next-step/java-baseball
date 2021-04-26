package nextstep.precourse.baseball;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BaseballNewNumber {

    Set<Integer> newRightNumber = new HashSet<>();

    public void newRandomNumber() {
        while(newRightNumber.size() < 3) {
            newRightNumber.add((int) (Math.random() * 9 + 1));
        }
    }

    public int[] randomNumberArrayInput() {
        int[] rightArray = new int[3];
        newRandomNumber();
        Iterator<Integer> rightNumberIterator = newRightNumber.iterator();

        int index = 0;
        while(rightNumberIterator.hasNext()) {
            rightArray[index++] = rightNumberIterator.next();
        }
        return randomNumberArraySwap(rightArray);
    }

    public int[] randomNumberArraySwap(int[] rightArray) {
        int index = 0;
        while(index++ < 50) {
            int randomIndex = (int) (Math.random() * rightArray.length);
            int temp = rightArray[0];
            rightArray[0] = rightArray[randomIndex];
            rightArray[randomIndex] = temp;
        }
        return rightArray;
    }
}
