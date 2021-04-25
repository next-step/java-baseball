package baseball;

import java.util.List;

import static baseball.constant.Constant.NUMBERS_LIMIT;

public class Numbers {
    private final List<Integer> gameNumbers;

    public Numbers(List<Integer> gameNumbers) {
        if (gameNumbers.size() != NUMBERS_LIMIT) {
            throw new IllegalArgumentException("게임숫자는 " + NUMBERS_LIMIT + "개이어야 합니다.");
        }
        this.gameNumbers = gameNumbers;
    }

    public int size() {
        return this.gameNumbers.size();
    }

    public int strike(List<Integer> userNumbers) {
        int strikeNumber = 0;
        for (Integer quizNumber : gameNumbers) {
            strikeNumber += strikeNumber(userNumbers, quizNumber);
        }
        return strikeNumber;
    }

    public int ball(List<Integer> userNumbers) {
        int ballNumber = 0;
        for (Integer quizNumber : gameNumbers) {
            ballNumber += ballNumber(userNumbers, quizNumber);
        }
        return ballNumber;
    }

    private int ballNumber(List<Integer> userNumbers, Integer quizNumber) {
        int ballNumber = 0;
        int userNumberIndex = userNumbers.indexOf(quizNumber);
        if (userNumberIndex != -1 && !gameNumbers.get(userNumberIndex).equals(quizNumber)) {
            ballNumber++;
        }
        return ballNumber;
    }

    private int strikeNumber(List<Integer> userNumbers, Integer quizNumber) {
        int strikeNumber = 0;
        int userNumberIndex = userNumbers.indexOf(quizNumber);
        if (userNumberIndex != -1 && gameNumbers.get(userNumberIndex).equals(quizNumber)) {
            strikeNumber++;
        }
        return strikeNumber;
    }
}
