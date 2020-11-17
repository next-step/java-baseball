package baseball;

/**
 * 스트라이크 힌트 클래스
 */
public class Strike extends Hint {
    /**
     * 스트라이크 힌트 출력
     */
    public void print() {
        if (getCount() != 0) {
            String name = "스트라이크";
            System.out.printf("%d%s", getCount(), name);
        }
    }
}
