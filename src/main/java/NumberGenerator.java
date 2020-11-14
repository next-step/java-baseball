import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 숫자야구게임을 위한 숫자 생성기. 규칙에 맞게 숫자배열을 생성하여 반환한다.
 */
final class NumberGenerator {

    private static final Random random = new Random(System.nanoTime());

    /**
     * 숫자 생성 메서드. 1부터 9까지의 서로 다른 숫자를 3개 생성하여 정수형 배열로 반환한다.
     *
     * @return int[3] 생성된 숫자를 배열에 담아 반환한다.
     */
    static int[] generate() {
        final List<Integer> pool = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        return new int[] {pick(pool), pick(pool), pick(pool)};
    }

    private static int pick(List<Integer> pool) {
        return pool.remove(random.nextInt(pool.size()));
    }

    private NumberGenerator() {}
}
