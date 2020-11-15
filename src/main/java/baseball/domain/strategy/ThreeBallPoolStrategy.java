package baseball.domain.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 랜덤한 3개의 숫자를 생성할 때
 * 이 클래스의 방법으로 생성하는것도 괜찮을꺼 같아 별도로 추가해보았습니다.
 * (사용은 안함)
 */
public class ThreeBallPoolStrategy implements BallGenerateStrategy {

    private static final List<Integer> POOL;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 3;

    static {
        List<Integer> pool = new ArrayList<>();

        for (int i = START_NUMBER; i < END_NUMBER; i++) {
            pool.add(i);
        }
        POOL = Collections.unmodifiableList(pool);
    }

    @Override
    public List<Integer> generate() {
        List<Integer> pool = new ArrayList<>(POOL);
        Collections.shuffle(pool);
        return pool.subList(START_INDEX, END_INDEX);
    }

}
