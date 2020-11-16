package baseball.game;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Random;

import baseball.exception.CustomException;
import baseball.common.PrintMessage;

public class CreateBall {

    private static final int MAX_NUMBER = 9;

    private static final int ZERO_NUMBER_EXCEPT = 1;

    private static final int COLLECTION_NUMBER_SIZE = 3;

    private static final int ZERO = 0;

    private final Random random;

    private final LinkedHashSet<Integer> balls;

    public CreateBall() {
        this.random = new Random();
        this.balls = createRandomBalls();
    }

    /**
     * 생성 된 랜덤 3개의 숫자(볼) 및 숫자 가져오기
     * @return 중복 없는 랜덤 3개의 숫자 LinkedHashSet
     */
    LinkedHashSet<Integer> getBalls() {
        return this.balls;
    }

    /**
     * 중복 없는 랜덤 3개의 숫자(볼) 생성하기
     * @return 중복 없는 랜덤 3개의 숫자 LinkedHashSet
     */
    public LinkedHashSet<Integer> createRandomBalls() {
        LinkedHashSet<Integer> baseBalls = new LinkedHashSet<>();

        while (isRandomBallSize(baseBalls)) {
            baseBalls.add(random.nextInt(MAX_NUMBER) + ZERO_NUMBER_EXCEPT);
        }

        validateRandomBall(baseBalls);

        return baseBalls;
    }

    /**
     * 현재 저장 된 랜덤 3개의 숫자(볼) 최소값 및 최대값 체크
     * @param balls 등록 된 랜덤 3개의 숫자(볼) LinkedHashSet
     */
    void validateRandomBallMax(final LinkedHashSet<Integer> balls) {
        int minNumber = Collections.min(balls);
        int maxNumber = Collections.max(balls);

        if (minNumber == ZERO || maxNumber >= MAX_NUMBER + ZERO_NUMBER_EXCEPT) {
            throw new CustomException.InvalidateRandomNumberMinMaxError(PrintMessage.RANDOM_NUMBER_MIN_MAX_ERROR);
        }
    }

    /**
     * 현재 저장 된 랜덤 크기 실제 원해는 배열의 크가가 맞는 지 체크
     * @param balls 등록 된 랜덤 3개의 숫자(볼) LinkedHashSet
     */
    void validateRandomBallSize(final LinkedHashSet<Integer> balls) {
        if (balls.size() != COLLECTION_NUMBER_SIZE) {
            throw new CustomException.InvalidateNumberSizeError(PrintMessage.RANDOM_NUMBER_SIZE_ERROR);
        }
    }

    /**
     * 랜덤 숫자(볼) 크기 체크
     * @param balls 등록 된 랜덤 3개의 숫자(볼) LinkedHashSet
     * @return 랜덤 숫자(볼) 크기 체크 결과 값
     */
    private boolean isRandomBallSize(final LinkedHashSet<Integer> balls) {
        return balls.size() != COLLECTION_NUMBER_SIZE;
    }

    /**
     * 랜덤 숫자(볼) 만들어진 객체 validate 체크 메소드
     * @param balls 등록 된 랜덤 3개의 숫자(볼) LinkedHashSet
     */
    private void validateRandomBall(final LinkedHashSet<Integer> balls) {
        validateRandomBallMax(balls);
        validateRandomBallSize(balls);
    }

}
