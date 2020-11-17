package edu.example.numberbaseball.common;

import edu.example.numberbaseball.util.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * `Ball`을 생성하기 위한 기능을 가진 클래스
 */
public class BallGenerator {
    private static final int VALID_BALL_SIZE = Inning.getNumberOfBalls();
    private static final int START_BALL_NUMBER = Ball.getStartNumber();
    private static final int END_BALL_NUMBER = Ball.getEndNumber();
    private static final Random RANDOM = new Random();

    private final List<Integer> availableNumberList = CollectionUtil.fillRange(START_BALL_NUMBER, END_BALL_NUMBER);

    public List<Ball> generateRandomBallList(int neededSize) {
        List<Ball> randomBallList = new ArrayList<>(neededSize);
        List<Integer> randomIntegerList = new BallGenerator().generateRandomIntegerList(neededSize);
        for (int randomInteger : randomIntegerList) {
            randomBallList.add(new Ball(randomInteger));
        }
        return randomBallList;
    }

    private List<Integer> generateRandomIntegerList(int neededSize) {
        if (neededSize != VALID_BALL_SIZE) {
            throw new IllegalArgumentException("생성할 수 있는 `Ball`의 갯수를 초과합니다.");
        }
        List<Integer> generatedNumberList = new ArrayList<>(neededSize);
        for (int i = 0; i < neededSize; i++) {
            generatedNumberList.add(generateNumber());
        }
        return generatedNumberList;
    }

    private int generateNumber() {

        int currentSize = availableNumberList.size();
        int selectedIndex = RANDOM.nextInt(currentSize);
        int selectedNumber = availableNumberList.get(selectedIndex);
        availableNumberList.remove(selectedIndex);
        return selectedNumber;
    }
}
