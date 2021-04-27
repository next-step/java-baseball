package nextstep.precourse.baseball;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BaseballNewNumber {

    BaseballUserInputNumberCompare baseballUserInputNumberCompare = new BaseballUserInputNumberCompare();

    /**
     * @return 정답과 입력받은 3자리 수를 비교하여 strike를 리턴
     */
    public int strikeResult() {
        return baseballUserInputNumberCompare.rightArrayAndUserInputCompare(randomNumberArrayInput());
    }

    /**
     * @return random으로 생성된 Set를 리턴
     */
    public Set<Integer> newRandomNumber() {
        Set<Integer> newRightNumber = new HashSet<>();
        while(newRightNumber.size() < 3) {
            newRightNumber.add((int) (Math.random() * 9 + 1));
        }
        return newRightNumber;
    }

    /**
     * @return 서로 다른 3자리 수를 배열로 리턴
     */
    public int[] randomNumberArrayInput() {
        int[] rightArray = new int[3];

        Iterator<Integer> rightNumberIterator = newRandomNumber().iterator();

        int index = 0;
        while(rightNumberIterator.hasNext()) {
            rightArray[index++] = rightNumberIterator.next();
        }
        return randomNumberArraySwap(rightArray);
    }

    /**
     * @param rightArray 서로 다른 3자리 수의 배열
     * @return 순서대로 저장된 배열을 섞는다
     */
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
