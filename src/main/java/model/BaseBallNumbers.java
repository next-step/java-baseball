package model;

import java.util.*;
import java.util.stream.Collectors;

public class BaseBallNumbers {
    private static final int NUMBERS_SIZE = 3;
    private final List<BallNumber> ballNumbers;

    private BaseBallNumbers(List<BallNumber> ballNumbers) {
        validate(ballNumbers);
        this.ballNumbers = ballNumbers;
    }

    private BaseBallNumbers() {
        this.ballNumbers = new ArrayList<>();
    }

    public List<BallNumber> getBallNumbers() {
        return ballNumbers;
    }

    private void validate(List<BallNumber> ballNumbers) {
        boolean isUnique = ballNumbers.stream().map(BallNumber::getNumber).allMatch(new HashSet<>()::add);
        if (!isUnique) {
            throw new IllegalArgumentException("숫자열에 중복된 수가 있습니다.");
        }

        if (ballNumbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("숫자열의 길이가 유효하지 않습니다.");
        }
    }

    @Override
    public String toString() {
        return ballNumbers.stream().map(Objects::toString).collect(Collectors.joining());
    }

    public void checkStrikeBall(Player player) {
        //TODO: 리팩터링
        int strike = 0;
        int ball = 0;
        BaseBallNumbers playersBallNumbers = player.getBaseBallNumbers();
        Set<BallNumber> copiedBalls = new HashSet<>(playersBallNumbers.ballNumbers);
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            if(ballNumbers.get(i).equals(playersBallNumbers.getBallNumbers().get(i))) {
                strike+=1;
                copiedBalls.remove(ballNumbers.get(i));
                continue;
            }
            if (copiedBalls.contains(ballNumbers.get(i))) {
                ball += 1;
            }
        }
        player.setStrike(strike);
        player.setBall(ball);
    }
    public static BaseBallNumbers of (List<BallNumber> ballNumbers) {
        return new BaseBallNumbers(new ArrayList<>(ballNumbers));
    }

    public static BaseBallNumbers of () {
        return new BaseBallNumbers();
    }


}
