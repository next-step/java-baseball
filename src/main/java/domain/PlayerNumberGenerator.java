package domain;

import java.util.*;

public class PlayerNumberGenerator implements BaseBallNumberGenerator {

    private static final int BALL_MAX_SIZE = 3;
    private List<BaseBallNumber> baseBallNumbers = new ArrayList<>();

    public PlayerNumberGenerator(int numbers) {
        checkNumberLength(numbers);
        generateBaseBallNumber(numbers);
        checkDuplicatedNumber();
    }

    private void generateBaseBallNumber(int numbers) {
        int divideNumber = 100;
        while(numbers != 0) {
            int ballNumber = numbers / divideNumber;
            baseBallNumbers.add(SourceNumbers.getBall(ballNumber));
            numbers %= divideNumber;
            divideNumber /= 10;
        }
    }

    private void checkNumberLength(int numbers) {
        if ((int)(Math.log10(numbers) + 1) != BALL_MAX_SIZE) {
            throw new IllegalArgumentException("세자리 정수를 입력해 주세요");
        }
    }

    private void checkDuplicatedNumber() {
        Set<BaseBallNumber> ballNumberSet = new HashSet<>(baseBallNumbers);
        if (ballNumberSet.size() < baseBallNumbers.size()) {
            throw new IllegalArgumentException("입력한 각 자리 숫자는 중복 될 수 없습니다.");
        }
    }

    @Override
    public List<BaseBallNumber> getNumbers() {
        return Collections.unmodifiableList(baseBallNumbers);
    }

}
