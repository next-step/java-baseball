package baseball;

/**
 * 포볼 힌트 클래스
 */
public class Nothing extends Hint {
    /**
     * 포볼 힌트 출력
     */
    public void print() {
        if (getCount() != 0) {
            String name = "포볼";
            System.out.printf("%s", name);
        }
    }
}
