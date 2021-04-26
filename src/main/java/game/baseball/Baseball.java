package game.baseball;

import java.util.ArrayList;

public class Baseball {
    int[] computerNumbers;
    int[] playerNumbers;
    int strikeCount;
    int ballCount;

    public Baseball() {
        strikeCount = 0;
        ballCount = 0;
        computerNumbers = new int[BaseballConstants.BASEBALL_COUNT];
        playerNumbers = new int[BaseballConstants.BASEBALL_COUNT];

        makeComputerNumbers();
    }

    public void checkStrikeAndBallCount() {
        checkStrikeCount();
        checkBallCount();
    }

    private boolean isBall(int index, int computerNumber) {
        boolean isBall = false;
        for (int i = 0; i < playerNumbers.length; i++) {
            isBall = (computerNumber == playerNumbers[i] && i != index  || isBall) ? true : false;
        }
        return isBall;
    }

    private void checkBallCount() {
        ballCount = 0;
        for (int i = 0; i < computerNumbers.length; i++) {
            ballCount += isBall(i, computerNumbers[i]) ? 1 : 0;
        }
    }

    private void checkStrikeCount() {
        strikeCount = 0;
        for (int i = 0; i < computerNumbers.length; i++) {
            strikeCount += (computerNumbers[i] == playerNumbers[i]) ? 1 : 0;
        }
    }

    public void makePlayerNumbers(int inputNumber) {
        for (int i = BaseballConstants.BASEBALL_COUNT - 1; i >= 0; i--) {
            playerNumbers[i] = inputNumber % 10;
            inputNumber /= 10;
        }
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
