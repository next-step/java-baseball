package baseball;

/**
 * 볼 힌트 클래스
 */
public class Ball extends Hint {
    /**
     * 볼 힌트 출력
     */
    public void print() {
        if (getCount() != 0) {
            String name = "볼";
            System.out.printf("%d%s", getCount(), name);
        }
    }
}