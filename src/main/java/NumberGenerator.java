import java.util.Random;

/**
 * 숫자야구게임을 위한 숫자 생성기. 규칙에 맞게 숫자배열을 생성하여 반환한다.
 */
public final class NumberGenerator {

    private static final Random random = new Random(System.nanoTime());

    /**
     * 숫자 생성 메서드. 1부터 9까지의 숫자를 3개 생성하여 정수형 배열로 반환한다.
     *
     * @return int[3] 생성된 숫자를 배열에 담아 반환한다.
     */
    public static int[] generate() {
        return new int[] { random(), random(), random()};
    }

    private static int random() {
        return random.nextInt(9) + 1;
    }

    private NumberGenerator() {}
}
